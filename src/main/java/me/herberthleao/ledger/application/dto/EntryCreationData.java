package me.herberthleao.ledger.application.dto;

import me.herberthleao.ledger.domain.entities.Entry;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public final class EntryCreationData extends DataTransferObject
{
    @NotNull(message = "Operation is required: CREDIT or DEBIT.")
    private Entry.Operation operation;

    @JsonProperty("account_id")
    @NotNull(message = "Account ID is required.")
    private UUID accountID;

    @NotNull(message = "Amount is required.")
    private BigDecimal amount;

    private String description;
    private String observation;
}
