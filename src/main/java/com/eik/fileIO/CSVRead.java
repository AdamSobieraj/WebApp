package com.eik.fileIO;

import com.eik.config.AdminConfig;
import com.eik.domain.dto.AgreementDto;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Service
public class CSVRead {

    @Autowired
    private AdminConfig adminConfig;

    private Set<AgreementDto> agreementDtoHashSet = new HashSet<>();


        public void readCSV() throws Exception{
            agreementDtoHashSet.clear();

                Reader reader = Files.newBufferedReader(Paths.get(adminConfig.getFolderPath()+ "/Agreements.csv"));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withFirstRecordAsHeader()
                        .withIgnoreHeaderCase()
                        .withTrim());

            for (CSVRecord csvRecord : csvParser) {

                Long agreementId = Long.parseLong(csvRecord.get("agreementId"));
                String system = csvRecord.get("system");
                Integer request = Integer.parseInt(csvRecord.get("request"));
                String orderNumber = csvRecord.get("orderNumber");
                LocalDate dateFrom = LocalDate.parse(csvRecord.get("dateFrom"));
                LocalDate dateTo = LocalDate.parse(csvRecord.get("dateTo"));
                Double amount = Double.parseDouble(csvRecord.get("amount"));
                String amountType = csvRecord.get("amountType");
                String amountPeriod = csvRecord.get("amountPeriod");
                Integer authorizationPercent = Integer.parseInt(csvRecord.get("authorizationPercent"));
                Boolean ative = Boolean.parseBoolean(csvRecord.get("ative"));

                AgreementDto agreementDto = new AgreementDto(
                        agreementId,
                        system,
                        request,
                        orderNumber,
                        dateFrom,
                        dateTo,
                        amount,
                        amountType,
                        amountPeriod,
                        authorizationPercent,
                        ative
                        );

                    agreementDtoHashSet.add(agreementDto);

            }

    }

    public Set<AgreementDto> getAgreementDtoHashSet() {
        return agreementDtoHashSet;
    }
}
