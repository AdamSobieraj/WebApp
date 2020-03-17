package com.eik.repository;

import com.eik.domain.Agreement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface AgreementDao extends CrudRepository<Agreement, Long> {

    @Override
    List<Agreement> findAll();

    @Override
    Agreement save( Agreement agreement);

    Optional<Agreement>findByAgreementId(Long id);

    void deleteByAgreementId(Long id);
}
