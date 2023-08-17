package me.herberthleao.ledger.application.dto;

import me.herberthleao.ledger.domain.entities.BaseEntity.Status;

import lombok.Data;

@Data
public abstract class DataTransferObject
{
    private Status status;
}
