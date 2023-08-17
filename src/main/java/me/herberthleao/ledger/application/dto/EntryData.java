package me.herberthleao.ledger.application.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.UUID;

import me.herberthleao.ledger.domain.entities.Entry;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public final class EntryData extends DataTransferObject
{
    private Entry.Operation operation;
    private UUID accountID;
    private BigDecimal amount;
    private BigDecimal previousBalance;
    private BigDecimal afterBalance;
    private String description;
    private String observation;
    private UUID userID;
}
