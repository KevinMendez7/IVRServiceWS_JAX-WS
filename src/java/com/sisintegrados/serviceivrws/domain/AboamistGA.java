/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisintegrados.serviceivrws.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Kevin Mendez
 */

@Entity
@Table(name = "GA_ABOAMIST")
public class AboamistGA implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUM_ABONADO")
    private long suscriberId;
    
    @Column(name = "NUM_CELULAR")
    private long phoneNumber;
    
    @Column(name = "COD_CLIENTE")
    private long subscriberCode;
    
    @Column(name = "COD_USO")
    private int usageCode;
    
    @Column(name = "COD_CENTRAL")
    private int centralCode;
    
    @Column(name = "COD_SITUACION")
    private String situationCode;
    
    @Column(name = "COD_CARGOBASICO")
    private String basicChargeCode;

    public AboamistGA() {
    }

    public long getSuscriberId() {
        return suscriberId;
    }

    public void setSuscriberId(long suscriberId) {
        this.suscriberId = suscriberId;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getSubscriberCode() {
        return subscriberCode;
    }

    public void setSubscriberCode(long subscriberCode) {
        this.subscriberCode = subscriberCode;
    }

    public int getUsageCode() {
        return usageCode;
    }

    public void setUsageCode(int usageCode) {
        this.usageCode = usageCode;
    }

    public int getCentralCode() {
        return centralCode;
    }

    public void setCentralCode(int centralCode) {
        this.centralCode = centralCode;
    }

    public String getSituationCode() {
        return situationCode;
    }

    public void setSituationCode(String situationCode) {
        this.situationCode = situationCode;
    }

    public String getBasicChargeCode() {
        return basicChargeCode;
    }

    public void setBasicChargeCode(String basicChargeCode) {
        this.basicChargeCode = basicChargeCode;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.suscriberId ^ (this.suscriberId >>> 32));
        hash = 97 * hash + (int) (this.phoneNumber ^ (this.phoneNumber >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AboamistGA other = (AboamistGA) obj;
        if (this.suscriberId != other.suscriberId) {
            return false;
        }
        if (this.phoneNumber != other.phoneNumber) {
            return false;
        }
        return true;
    }
    
    
    
}
