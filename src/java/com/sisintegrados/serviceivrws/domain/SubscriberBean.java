/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisintegrados.serviceivrws.domain;

/**
 *
 * @author MGN04582
 */
public class SubscriberBean {
    
    private long phoneNumber;
    private boolean exceptionNumber;
    private boolean freePlan;
    private String segment;
    private String category;
    private boolean transferSchedule;
    private boolean transferRecaller;
    private String transferCode;
    
    public SubscriberBean(long phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isExceptionNumber() {
        return exceptionNumber;
    }

    public void setExceptionNumber(boolean exceptionNumber) {
        this.exceptionNumber = exceptionNumber;
    }

    public boolean isFreePlan() {
        return freePlan;
    }

    public void setFreePlan(boolean freePlan) {
        this.freePlan = freePlan;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isTransferSchedule() {
        return transferSchedule;
    }

    public void setTransferSchedule(boolean transferSchedule) {
        this.transferSchedule = transferSchedule;
    }

    public boolean isTransferRecaller() {
        return transferRecaller;
    }

    public void setTransferRecaller(boolean transferRecaller) {
        this.transferRecaller = transferRecaller;
    }

    public String getTransferCode() {
        return transferCode;
    }

    public void setTransferCode(String transferCode) {
        this.transferCode = transferCode;
    }
    
    
    
}
