package me.herberthleao.ledger.domain.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "entries")
@Data
@EqualsAndHashCode(callSuper = false)
public final class Entry extends BaseEntity
{
    public enum Operation {
        CREDIT,
        DEBIT
    }

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Operation operation;

    @OneToOne(optional = false)
    private Account account;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private BigDecimal previousBalance;

    @Column(nullable = false)
    private BigDecimal afterBalance;

    private String description;

    private String observation;

    @OneToOne(optional = false)
    private User user;
}
