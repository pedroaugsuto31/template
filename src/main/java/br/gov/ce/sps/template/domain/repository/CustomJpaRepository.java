package br.gov.ce.sps.template.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomJpaRepository<T, U> extends JpaRepository<T, U>, JpaSpecificationExecutor<T> {
    void detach(T entity);
}