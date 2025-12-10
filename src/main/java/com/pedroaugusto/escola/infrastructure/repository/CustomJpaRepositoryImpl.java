package com.pedroaugusto.escola.infrastructure.repository;

import com.pedroaugusto.escola.domain.repository.CustomJpaRepository;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class CustomJpaRepositoryImpl<T, U> extends SimpleJpaRepository<T, U> implements CustomJpaRepository<T, U> {

    private final EntityManager manager;

    public CustomJpaRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);

        this.manager = entityManager;
    }

    @Override
    public void detach(T entity) {
        manager.detach(entity);
    }

}
