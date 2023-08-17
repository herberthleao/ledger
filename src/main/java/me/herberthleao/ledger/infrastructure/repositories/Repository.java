package me.herberthleao.ledger.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface Repository<T, ID> extends JpaRepository<T, ID>
{
    @Override
    @Query("SELECT e FROM #{#entityName} e WHERE e.status <> 'DELETED' AND e.id = ?1")
    Optional<T> findById(ID id);

    @Override
    @Query("SELECT e FROM #{#entityName} e WHERE e.status <> 'DELETED'")
    List<T> findAll();

    @Query("SELECT e FROM #{#entityName} e WHERE e.status <> 'DELETED'")
    Optional<T> findFirst();

    @Override
    @RestResource(exported = false)
    void delete(T entity);

    @Override
    @RestResource(exported = false)
    void deleteAll();

    @Override
    @RestResource(exported = false)
    void deleteById(ID id);

    @Query("UPDATE #{#entityName} e SET e.status = 'DELETED' WHERE e.id = ?1")
    void markAsDeleted(ID id);
}