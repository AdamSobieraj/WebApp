package com.eik.repository;

import com.eik.domain.SystemType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface SystemDao extends CrudRepository<SystemType, Long> {

    @Override
    List<SystemType> findAll();

    @Override
    SystemType save(SystemType system);

    Optional<SystemType> findBySystemId(Long id);

    void deleteBySystemId(Long id);
}
