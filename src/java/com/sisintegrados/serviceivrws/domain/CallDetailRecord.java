/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisintegrados.serviceivrws.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 *
 * @author MGN04582
 */

@Entity
@Table(name = "TC_IVR_CDR")
public class CallDetailRecord {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "TC_IVR_CDR_SQ")
    @Column(name = "TCIVRCDRID")     
    private long id;
    
    @Column(name = "ANI_CLIENTE") 
    private long msisdn;
    
    @Column(name = "INICIO") 
    private Date startDate;
    
    @Column(name = "FINAL", insertable = false, updatable = false) 
    private Date endDate;
    
    @Column(name = "ESTADO") 
    private short state;
    
    @Column(name = "NUMERO_DESTINO") 
    private String transferCode;
    
    @Column(name = "RUTA_LLAMADA") 
    private String callPath;
    
    @Column(name = "SWDATECREATED", insertable = false, updatable = false) 
    private Date date;
    
    @Column(name = "SWCREATEDBY") 
    private String originator;
    
    @Column(name = "RUTA_TIEMPOS") 
    private String timePath;
    
    @Column(name = "SMS_CONFIG") 
    private String packageCode;
    
    @Column(name = "TIPO_PRODUCTO") 
    private short subscriberType;
    
    public CallDetailRecord(long msisdn, Date startDate, String transferCode, String callPath, String originator, String timePath, String packageCode, short subscriberType){
        this.msisdn = msisdn;
        this.startDate = startDate; 
        this.transferCode = transferCode;
        this.callPath = callPath;
        this.timePath = timePath;
        this.packageCode = packageCode;
        this.subscriberType = subscriberType;
        this.originator = originator;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(long msisdn) {
        this.msisdn = msisdn;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public String getTransferCode() {
        return transferCode;
    }

    public void setTransferCode(String transferCode) {
        this.transferCode = transferCode;
    }

    public String getCallPath() {
        return callPath;
    }

    public void setCallPath(String callPath) {
        this.callPath = callPath;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOriginator() {
        return originator;
    }

    public void setOriginator(String originator) {
        this.originator = originator;
    }

    public String getTimePath() {
        return timePath;
    }

    public void setTimePath(String timePath) {
        this.timePath = timePath;
    }

    public String getPackageCode() {
        return packageCode;
    }

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }

    public short getSubscriberType() {
        return subscriberType;
    }

    public void setSubscriberType(short subscriberType) {
        this.subscriberType = subscriberType;
    }
    
    
    
}
