package com.eik.controller;

import com.eik.domain.dto.AgreementDto;
import com.eik.fileIO.CSVRead;
import com.eik.fileIO.SaveCSVToDb;
import com.eik.mapper.AgreementMapper;
import com.eik.service.DbAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin("*")//allow no security
@RequestMapping("/v1/agreement")
public class AgreementController{

    private final DbAgreementService dbAgreementService;

    private final AgreementMapper agreementMapper;

    private final CSVRead csvRead;

    private final SaveCSVToDb saveCSVToDb;

    @Autowired
    public AgreementController(DbAgreementService dbAgreementService, AgreementMapper agreementMapper, CSVRead csvRead, SaveCSVToDb saveCSVToDb) {
        this.dbAgreementService = dbAgreementService;
        this.agreementMapper = agreementMapper;
        this.csvRead = csvRead;
        this.saveCSVToDb = saveCSVToDb;
    }

    @RequestMapping(method = RequestMethod.GET, value = "agreements")
    public List<AgreementDto> getAgreements(){return agreementMapper.mapToAgreementDtoList(dbAgreementService.getAllAgreements());}

    @RequestMapping(method = RequestMethod.GET, value = "agreementsActive")
    public List<AgreementDto> getAgreementsActive(){

        List<AgreementDto> activeAgreements = agreementMapper.mapToAgreementDtoList(dbAgreementService.getAllAgreements());
        List<AgreementDto> output = new LinkedList<>();
        for (AgreementDto agr: activeAgreements) {
            if (agr.getAtive().equals(true)){
                output.add(agr);
            }
        }
        return output;
    }

//    @RequestMapping(method = RequestMethod.GET, value = "readcsv")
//    public List<AgreementDto> getAgreementsCsv(){
//        csvRead.readCSV();
//        return csvRead.getAgreementDtoHashSet().stream().collect(Collectors.toList());
//    }

    @RequestMapping(method = RequestMethod.GET, value = "readcsv")
    public ResponseEntity<List<AgreementDto>> getAgreementsCsv(){
        try {
            csvRead.readCSV();
            return ResponseEntity.ok().body(csvRead.getAgreementDtoHashSet().stream().collect(Collectors.toList()));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }


    @RequestMapping(method = RequestMethod.GET, value = "writecsvdob")
    public ResponseEntity<String> getAgreementsCsvDbWrite(){
        if(csvRead.getAgreementDtoHashSet().size()!=0){
            saveCSVToDb.saveData(csvRead.getAgreementDtoHashSet());
            return ResponseEntity.ok("Udany eksport do bazy danych");
        }else {
            return ResponseEntity.ok("Błąd brak danych");
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/agreements/{id}")
    public AgreementDto getAgreement(@PathVariable Long id) throws NotFoundException{
        return agreementMapper.mapToAgreementDto(dbAgreementService.getAgreementById(id));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createAgreement", consumes = APPLICATION_JSON_VALUE)
    public void addAgreement(@RequestBody AgreementDto agreementDto){
        dbAgreementService.saveAgreement(agreementMapper.mapToAgreement(agreementDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateAgreement")
    public AgreementDto updateAgreement(@RequestBody AgreementDto agreementDto){
        return agreementMapper.mapToAgreementDto(dbAgreementService.saveAgreement(agreementMapper.mapToAgreement(agreementDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteAgreement/{id}")
    public void deleteAgreement(@PathVariable Long id){
        dbAgreementService.deleteAgreement(id);
    }
}
