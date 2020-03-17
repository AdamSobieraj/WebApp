package com.eik.controller;

import com.eik.domain.dto.SystemDto;
import com.eik.mapper.SystemMapper;
import com.eik.service.DbSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin("*")//allow no security
@RequestMapping("/v1/system")
public class SystemController {

    @Autowired
    private DbSystemService dbSystemService;

    @Autowired
    private SystemMapper systemMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getSystems")
    public List<SystemDto> getSystems(){
        return systemMapper.mapToSystemDtoList(dbSystemService.getAllSystems());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getSystem/{id}")
    public SystemDto getSystem(@PathVariable Long id) throws NotFoundException{
        return systemMapper.mapToSystemDto(dbSystemService.getSystemById(id));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createSystem", consumes = APPLICATION_JSON_VALUE )
    public void addSystem(@RequestBody SystemDto systemDto){
        dbSystemService.saveSystem(systemMapper.mapToSystem(systemDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateSystem")
    public SystemDto updateSystem(@RequestBody SystemDto systemDto){
        return systemMapper.mapToSystemDto(dbSystemService.saveSystem(systemMapper.mapToSystem(systemDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteSystem/{id}")
    public void deleteSystem(@PathVariable Long id){
        dbSystemService.deleteSystem(id);
    }
}
