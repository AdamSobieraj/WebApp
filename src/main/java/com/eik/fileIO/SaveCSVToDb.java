package com.eik.fileIO;

import com.eik.domain.dto.AgreementDto;
import com.eik.mapper.AgreementMapper;
import com.eik.service.DbAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SaveCSVToDb {

    @Autowired
    private DbAgreementService dbAgreementService;

    @Autowired
    private AgreementMapper agreementMapper;

    public void saveData(Set<AgreementDto> agreementDtos){

        for (AgreementDto tmp: agreementDtos){
            dbAgreementService.saveAgreement(agreementMapper.mapToAgreement(tmp));
        }
    }
}
