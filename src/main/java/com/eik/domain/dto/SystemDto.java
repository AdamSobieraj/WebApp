package com.eik.domain.dto;

public class SystemDto {

    private Long systemId;
    private String nameOfTheSystem;
    private String systemDescription;
    private String systemTechnologyDesc;
    private String systemOwner;

    public SystemDto() {
    }

    public SystemDto(Long systemId, String nameOfTheSystem, String systemDescription, String systemTechnologyDesc, String systemOwner) {
        this.systemId = systemId;
        this.nameOfTheSystem = nameOfTheSystem;
        this.systemDescription = systemDescription;
        this.systemTechnologyDesc = systemTechnologyDesc;
        this.systemOwner = systemOwner;
    }

    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public String getNameOfTheSystem() {
        return nameOfTheSystem;
    }

    public void setNameOfTheSystem(String nameOfTheSystem) {
        this.nameOfTheSystem = nameOfTheSystem;
    }

    public String getSystemDescription() {
        return systemDescription;
    }

    public void setSystemDescription(String systemDescription) {
        this.systemDescription = systemDescription;
    }

    public String getSystemTechnologyDesc() {
        return systemTechnologyDesc;
    }

    public void setSystemTechnologyDesc(String systemTechnologyDesc) {
        this.systemTechnologyDesc = systemTechnologyDesc;
    }

    public String getSystemOwner() {
        return systemOwner;
    }

    public void setSystemOwner(String systemOwner) {
        this.systemOwner = systemOwner;
    }
}
