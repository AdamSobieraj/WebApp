package com.eik.domain.dto;

import com.eik.domain.Agreement;

import java.time.LocalDate;
import java.util.Date;

public class AgreementDto {

    private Long agreementId;
    private String orderNumber;
    private String system;
    private Integer request;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private Double amount;
    private String amountType;
    private String amountPeriod;
    private Integer authorizationPercent;
    private Boolean ative;

    public AgreementDto() {
    }

    public AgreementDto( Long agreementId, String system, Integer request, String orderNumber, LocalDate dateFrom, LocalDate dateTo, Double amount, String amountType, String amountPeriod, Integer authorizationPercent, Boolean ative) {
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

    @Override
    public boolean equals(Object o){
        final Agreement e = (Agreement) o;
        return  this.agreementId.equals(e.getAgreementId()) &&
                this.ative.equals(e.getAtive())&&
                this.amount.equals(e.getAmount())&&
                this.amountPeriod.equals(e.getAmountPeriod())&&
                this.amountType.equals(e.getAmountType())&&
                this.authorizationPercent.equals(e.getAuthorizationPercent())&&
                this.dateFrom.equals(e.getDateFrom())&&
                this.dateTo.equals(e.getDateTo())&&
                this.orderNumber.equals(e.getOrderNumber())&&
                this.request.equals(e.getRequest())&&
                this.system.equals(e.getSystem());
    }

    @Override
    public int hashCode(){
        String order = orderNumber.replace("/","");
        return request + Integer.parseInt(order);
    }

}
