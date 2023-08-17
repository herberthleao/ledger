package me.herberthleao.ledger.infrastructure.repositories;

import me.herberthleao.ledger.domain.entities.AccountType;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(path = "account-types")
public interface AccountTypeRepository extends Repository<AccountType, UUID>
{}
