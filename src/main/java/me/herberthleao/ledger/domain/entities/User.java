package me.herberthleao.ledger.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public final class User extends BaseEntity
{
    private static final long serialVersionUID = 1L;
}
