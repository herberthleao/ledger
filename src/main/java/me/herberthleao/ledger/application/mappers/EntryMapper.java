package me.herberthleao.ledger.application.mappers;

import me.herberthleao.ledger.application.dto.EntryCreationData;
import me.herberthleao.ledger.domain.entities.Entry;

import org.springframework.stereotype.Component;

@Component
public final class EntryMapper
{
    public Entry mapCreationToEntity(EntryCreationData data)
    {
        var entity = new Entry();
        entity.setOperation(data.getOperation());
        entity.setAmount(data.getAmount());
        entity.setDescription(data.getDescription());
        entity.setObservation(data.getObservation());

        return entity;
    }
}
