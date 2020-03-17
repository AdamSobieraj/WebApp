package com.eik.service;

import com.eik.domain.Agreement;
import com.eik.repository.AgreementDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbAgreementsServiceTest {

    private Agreement agreement;

    @Autowired
    private DbAgreementService agreementService;

    @Autowired
    private AgreementDao agreementDao;

    @Before
    public void before(){
        LocalDate from = LocalDate.parse("2012-07-13");
        LocalDate to = LocalDate.parse("2020-04-03");

        agreement = new Agreement("ROMEK", 3355, "44/2011", from, to , 150.00, "BRU", "MONTH", 2, false);
    }

    @Test
    public void testGetAllAgreements(){
        //Given
        agreementDao.save(agreement);
        //When
        List<Agreement> test = agreementService.getAllAgreements();
        //Then
        assertEquals(1, test.size());
        //CleanUp
        agreementDao.deleteByAgreementId(agreement.getAgreementId());
    }

    @Test
    public void testAgreementById(){
        //Given
        agreementDao.save(agreement);
        Long id = agreement.getAgreementId();
        //When
        Agreement test = agreementService.getAgreementById(id);
        //Then
        assertEquals("ROMEK", test.getSystem());
        //CleanUp
        agreementDao.deleteByAgreementId(agreement.getAgreementId());
    }

    @Test
    public void testSaveAgreement(){
        //When
        agreementService.saveAgreement(agreement);
        //Then
        assertEquals(1, agreementService.getAllAgreements().size());
        //CleanUp
        agreementDao.deleteByAgreementId(agreement.getAgreementId());
    }

    @Test
    public void testDeleteAgreements(){
        //Given
        agreementService.saveAgreement(agreement);
        //When
        agreementService.deleteAgreement(agreement.getAgreementId());
        //Then
        assertEquals(0, agreementService.getAllAgreements().size());
    }
}
