package me.herberthleao.ledger.domain.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "institutions")
@Data
@EqualsAndHashCode(callSuper = false)
public final class Institution extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true, length = 3)
    private String code;

    private String logo;
}