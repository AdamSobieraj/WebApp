package com.eik.mapper;

import com.eik.domain.Agreement;
import com.eik.domain.dto.AgreementDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AgreementMapper {

    public Agreement mapToAgreement(final AgreementDto agreementDto){
        return new Agreement(
                agreementDto.getAgreementId(),
                agreementDto.getSystem(),
                agreementDto.getRequest(),
                agreementDto.getOrderNumber(),
                agreementDto.getDateFrom(),
                agreementDto.getDateTo(),
                agreementDto.getAmount(),
                agreementDto.getAmountType(),
                agreementDto.getAmountPeriod(),
                agreementDto.getAuthorizationPercent(),
                agreementDto.getAtive()
        );
    }

    public AgreementDto mapToAgreementDto(final Agreement agreement){
        return new AgreementDto(
                agreement.getAgreementId(),
                agreement.getSystem(),
                agreement.getRequest(),
                agreement.getOrderNumber(),
                agreement.getDateFrom(),
                agreement.getDateTo(),
                agreement.getAmount(),
                agreement.getAmountType(),
                agreement.getAmountPeriod(),
                agreement.getAuthorizationPercent(),
                agreement.getAtive()
        );
    }

    public List<AgreementDto> mapToAgreementDtoList(final List<Agreement> agreementList){
        return agreementList.stream()
                .map(t-> new AgreementDto(
                        t.getAgreementId(),
                        t.getSystem(),
                        t.getRequest(),
                        t.getOrderNumber(),
                        t.getDateFrom(),
                        t.getDateTo(),
                        t.getAmount(),
                        t.getAmountType(),
                        t.getAmountPeriod(),
                        t.getAuthorizationPercent(),
                        t.getAtive()))
                .collect(Collectors.toList());
    }

}
