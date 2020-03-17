package com.eik.mapper;

import com.eik.domain.SystemType;
import com.eik.domain.dto.SystemDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SystemMapper {

    public SystemType mapToSystem(final SystemDto systemDto){
        return new SystemType(
                systemDto.getSystemId(),
                systemDto.getNameOfTheSystem(),
                systemDto.getSystemDescription(),
                systemDto.getSystemTechnologyDesc(),
                systemDto.getSystemOwner()
        );
    }

    public SystemDto mapToSystemDto(final SystemType systemType){
        return new SystemDto(
                systemType.getSystemId(),
                systemType.getNameOfTheSystem(),
                systemType.getSystemDescription(),
                systemType.getSystemTechnologyDesc(),
                systemType.getSystemOwner()
        );
    }

    public List<SystemDto> mapToSystemDtoList(final List<SystemType> systemTypesList){
        return systemTypesList.stream()
                .map(t -> new SystemDto(    t.getSystemId(),
                                            t.getNameOfTheSystem(),
                                            t.getSystemDescription(),
                                            t.getSystemTechnologyDesc(),
                                            t.getSystemOwner()))
                .collect(Collectors.toList());
    }

}
