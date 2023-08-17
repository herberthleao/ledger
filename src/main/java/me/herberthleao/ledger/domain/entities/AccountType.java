package me.herberthleao.ledger.domain.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "account_types")
@Data
@EqualsAndHashCode(callSuper = false)
public final class AccountType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    @Column(nullable = false, unique = true)
    private String name;

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
