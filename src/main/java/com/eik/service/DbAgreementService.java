package com.eik.service;

import com.eik.domain.Agreement;
import com.eik.repository.AgreementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbAgreementService {

    private final AgreementDao agreementDao;

    public DbAgreementService(AgreementDao agreementDao) {
        this.agreementDao = agreementDao;
    }

    public List<Agreement> getAllAgreements(){return agreementDao.findAll();}

    public Agreement getAgreementById(final Long orderNumber){
        return agreementDao.findByAgreementId(orderNumber).orElse(null);
    }

    public Agreement saveAgreement(final Agreement agreement){return agreementDao.save(agreement);}

    public void deleteAgreement(final Long orderNumber){agreementDao.deleteByAgreementId(orderNumber);}
}
