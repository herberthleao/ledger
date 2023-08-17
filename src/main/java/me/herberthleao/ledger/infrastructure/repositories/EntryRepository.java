package me.herberthleao.ledger.infrastructure.repositories;

import me.herberthleao.ledger.domain.entities.Entry;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(exported = false)
public interface EntryRepository extends Repository<Entry, UUID>
{}