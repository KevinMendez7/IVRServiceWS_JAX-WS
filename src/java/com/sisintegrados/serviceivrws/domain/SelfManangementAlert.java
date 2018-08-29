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
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author MGN04582
 */
@Entity
@Table(name = "AUTOG_ALERTAS")
public class SelfManangementAlert {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    @SequenceGenerator(name = "id_sequence", sequenceName = "AUTOG_ALERTAS_SQ")
    @Column(name = "CORRELATIVO_ALERTA")
    private long alertId;
    
    @Column(name = "FECHA_ALERTA", insertable = false, updatable = false)
    private Date alertDate;
    
    @Column(name = "DESC_ALERTA")
    private String alertDescription;
            
    @Column(name = "NUMERO")
    private long msisdn;
    
    @Column(name = "OPCION")
    private String alertOption;
    
    @Column(name = "ESTADO")
    private String alertState;
    
    @Column(name = "IVR")
    private String alertIVR;
    
    @Column(name = "DETALLE_ALERTA")
    private String alertDetail;

    public SelfManangementAlert(String alertDescription, long msisdn, String alertOption, String alertState, String alertIVR, String alertDetail) {
        this.alertDescription = alertDescription;
        this.msisdn = msisdn;
        this.alertOption = alertOption;
        this.alertState = alertState;
        this.alertIVR = alertIVR;
        this.alertDetail = alertDetail;
    }        

    public long getAlertId() {
        return alertId;
    }

    public void setAlertId(long alertId) {
        this.alertId = alertId;
    }

    public Date getAlertDate() {
        return alertDate;
    }

    public void setAlertDate(Date alertDate) {
        this.alertDate = alertDate;
    }

    public String getAlertDescription() {
        return alertDescription;
    }

    public void setAlertDescription(String alertDescription) {
        this.alertDescription = alertDescription;
    }

    public long getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(long msisdn) {
        this.msisdn = msisdn;
    }

    public String getAlertOption() {
        return alertOption;
    }

    public void setAlertOption(String alertOption) {
        this.alertOption = alertOption;
    }

    public String getAlertState() {
        return alertState;
    }

    public void setAlertState(String alertState) {
        this.alertState = alertState;
    }

    public String getAlertIVR() {
        return alertIVR;
    }

    public void setAlertIVR(String alertIVR) {
        this.alertIVR = alertIVR;
    }

    public String getAlertDetail() {
        return alertDetail;
    }

    public void setAlertDetail(String alertDetail) {
        this.alertDetail = alertDetail;
    }
    
    
    
}
