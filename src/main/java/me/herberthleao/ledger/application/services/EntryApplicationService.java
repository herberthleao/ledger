package me.herberthleao.ledger.application.services;

import me.herberthleao.ledger.application.dto.EntryCreationData;
import me.herberthleao.ledger.application.mappers.EntryMapper;
import me.herberthleao.ledger.domain.entities.Entry;
import me.herberthleao.ledger.infrastructure.repositories.AccountRepository;
import me.herberthleao.ledger.infrastructure.repositories.EntryRepository;
import me.herberthleao.ledger.infrastructure.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public final class EntryApplicationService
{
    private EntryRepository entryRepository;
    private AccountRepository accountRepository;
    private UserRepository userRepository;
    private EntryMapper entryMapper;

    public EntryApplicationService(
        EntryRepository entryRepository,
        AccountRepository accountRepository,
        UserRepository userRepository,
        EntryMapper entryMapper
    ) {
        this.entryRepository = entryRepository;
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
        this.entryMapper = entryMapper;
    }

    public void registerEntry(EntryCreationData data)
    {
        var account = this.accountRepository.findById(
            data.getAccountID()
        ).orElseThrow();
        var previousBalance = account.getBalance();
        var afterBalance = (data.getOperation() == Entry.Operation.DEBIT)
            ? account.subtractAmount(data.getAmount())
            : account.addAmount(data.getAmount());

        var entry = entryMapper.mapCreationToEntity(data);
        entry.setPreviousBalance(previousBalance);
        entry.setAfterBalance(afterBalance);
        entry.setAccount(account);
        entry.setUser(this.userRepository.findFirst().orElseThrow());

        this.accountRepository.save(account);
        this.entryRepository.save(entry);
    }
}