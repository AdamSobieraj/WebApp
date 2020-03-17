package com.eik.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "AGREEMENT")
public class Agreement {

    @Id
    @NotNull
    @Column(name = "agreementId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long agreementId;

    @NotNull
    @Column(name = "order_number")
    private String orderNumber;

    @NotNull
    @Column(name = "stsystem")
    private String system;

    @NotNull
    @Column(name = "request")
    private Integer request;

    @NotNull
    @Column(name = "from_date")
    private LocalDate dateFrom;

    @NotNull
    @Column(name = "to_date")
    private LocalDate dateTo;

    @NotNull
    @Column(name = "amount")
    private Double amount;

    @NotNull
    @Column(name = "amount_type")
    private String amountType;

    @NotNull
    @Column(name = "amount_period")
    private String amountPeriod;

    @NotNull
    @Column(name = "authorization_percent")
    private Integer authorizationPercent;

    @NotNull
    @Column(name = "active")
    private Boolean ative;

    public Agreement() {
    }

    public Agreement(Long agreementId,String system, Integer request, String orderNumber, LocalDate dateFrom, LocalDate dateTo, Double amount, String amountType, String amountPeriod, Integer authorizationPercent, Boolean ative) {
        this.agreementId = agreementId;
        this.system = system;
        this.request = request;
        this.orderNumber = orderNumber;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.amount = amount;
        this.amountType = amountType;
        this.amountPeriod = amountPeriod;
        this.authorizationPercent = authorizationPercent;
        this.ative = ative;
    }

    public Agreement(String system, Integer request, String orderNumber, LocalDate dateFrom, LocalDate dateTo, Double amount, String amountType, String amountPeriod, Integer authorizationPercent, Boolean ative) {
        this.system = system;
        this.request = request;
        this.orderNumber = orderNumber;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.amount = amount;
        this.amountType = amountType;
        this.amountPeriod = amountPeriod;
        this.authorizationPercent = authorizationPercent;
        this.ative = ative;
    }

    public Long getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(Long agreementId) {
        this.agreementId = agreementId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public Integer getRequest() {
        return request;
    }

    public void setRequest(Integer request) {
        this.request = request;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getAmountType() {
        return amountType;
    }

    public void setAmountType(String amountType) {
        this.amountType = amountType;
    }

    public String getAmountPeriod() {
        return amountPeriod;
    }

    public void setAmountPeriod(String amountPeriod) {
        this.amountPeriod = amountPeriod;
    }

    public Integer getAuthorizationPercent() {
        return authorizationPercent;
    }

    public void setAuthorizationPercent(Integer authorizationPercent) {
        this.authorizationPercent = authorizationPercent;
    }

    public Boolean getAtive() {
        return ative;
    }

    public void setAtive(Boolean ative) {
        this.ative = ative;
    }
}
