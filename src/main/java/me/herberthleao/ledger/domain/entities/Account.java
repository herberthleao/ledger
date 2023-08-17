package me.herberthleao.ledger.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public final class Account extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    @OneToOne(optional = false)
    private User user;

    @OneToOne(optional = false)
    private Institution institution;

    @OneToOne(optional = false)
    private AccountType type;

    @Column(nullable = false)
    private BigDecimal balance;

    public BigDecimal getBalance()
    {
        return this.balance;
    }

    public BigDecimal addAmount(BigDecimal amount)
    {
        this.balance = this.balance.add(amount);

        return this.balance;
    }

    public BigDecimal subtractAmount(BigDecimal amount)
    {
        this.balance = this.balance.subtract(amount);

        return this.balance;
    }
}
