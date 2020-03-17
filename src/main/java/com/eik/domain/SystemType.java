package com.eik.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SYSTEMTYPE")
public class SystemType {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long systemId;

    @NotNull
    @Column(name = "name")
    private String nameOfTheSystem;

    @NotNull
    @Column(name = "description")
    private String systemDescription;

    @NotNull
    @Column(name = "technologyDesc")
    private String systemTechnologyDesc;

    @NotNull
    @Column(name = "owner")
    private String systemOwner;

    public SystemType() {
    }

    public SystemType(Long systemId, String nameOfTheSystem, String systemDescription, String systemTechnologyDesc, String systemOwner) {
        this.systemId = systemId;
        this.nameOfTheSystem = nameOfTheSystem;
        this.systemDescription = systemDescription;
        this.systemTechnologyDesc = systemTechnologyDesc;
        this.systemOwner = systemOwner;
    }

    public SystemType( String nameOfTheSystem, String systemDescription, String systemTechnologyDesc, String systemOwner) {
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
