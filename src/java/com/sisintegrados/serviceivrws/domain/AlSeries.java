/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisintegrados.serviceivrws.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author MGN04582
 */

@Entity
@Table(name = "AL_SERIES")
public class AlSeries implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUM_SERIE")
    private String codeSerie;
    
    @Column(name = "COD_USO")
    private short useCode;
    
    @Column(name = "COD_CENTRAL")
    private short centralCode;
    
    @Column(name = "NUM_TELEFONO")
    private long phoneNumber;
            
    @Column(name = "IND_TELEFONO")
    private short phoneNumberInd;

    public AlSeries() {
    }

    public String getCodeSerie() {
        return codeSerie;
    }

    public void setCodeSerie(String codeSerie) {
        this.codeSerie = codeSerie;
    }

    public short getUseCode() {
        return useCode;
    }

    public void setUseCode(short useCode) {
        this.useCode = useCode;
    }

    public short getCentralCode() {
        return centralCode;
    }

    public void setCentralCode(short centralCode) {
        this.centralCode = centralCode;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public short getPhoneNumberInd() {
        return phoneNumberInd;
    }

    public void setPhoneNumberInd(short phoneNumberInd) {
        this.phoneNumberInd = phoneNumberInd;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.codeSerie);
        hash = 59 * hash + (int) (this.phoneNumber ^ (this.phoneNumber >>> 32));
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
        final AlSeries other = (AlSeries) obj;
        if (this.phoneNumber != other.phoneNumber) {
            return false;
        }
        if (!Objects.equals(this.codeSerie, other.codeSerie)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
