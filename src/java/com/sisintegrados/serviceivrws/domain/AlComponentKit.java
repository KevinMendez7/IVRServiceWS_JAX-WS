/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisintegrados.serviceivrws.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author MGN04582
 */

@Entity
@Table(name = "AL_COMPONENTE_KIT")
public class AlComponentKit {    
    
    @Id
    @Column(name = "NUM_KIT")
    private String numKit;
    
    @Column(name = "COD_KIT")
    private int codeKit;        
    
    @Column(name = "COD_USO")
    private short usageCode;
    
    @Column(name = "COD_CENTRAL")
    private int centralCode;
    
    @Column(name = "NUM_TELEFONO")
    private long phoneNumber;
            
    @Column(name = "IND_TELEFONO")
    private short phoneNumberInd;
    
    @Column(name = "COD_ESTADO")
    private short stateCode;        
    
    @Column(name = "TIP_STOCK")
    private short typeStock;
    
    @Column(name = "NUM_SERIE")
    private String codSerie;
    
    @Column(name = "COD_ARTICULO")
    private int articleCode;

    public AlComponentKit() {
    }

    public String getNumKit() {
        return numKit;
    }

    public void setNumKit(String numKit) {
        this.numKit = numKit;
    }

    public int getCodeKit() {
        return codeKit;
    }

    public void setCodeKit(int codeKit) {
        this.codeKit = codeKit;
    }

    public short getUsageCode() {
        return usageCode;
    }

    public void setUsageCode(short usageCode) {
        this.usageCode = usageCode;
    }

    public int getCentralCode() {
        return centralCode;
    }

    public void setCentralCode(int centralCode) {
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

    public short getStateCode() {
        return stateCode;
    }

    public void setStateCode(short stateCode) {
        this.stateCode = stateCode;
    }   

    public short getTypeStock() {
        return typeStock;
    }

    public void setTypeStock(short typeStock) {
        this.typeStock = typeStock;
    }

    public String getNumSerie() {
        return codSerie;
    }

    public void setNumSerie(String numSerie) {
        this.codSerie = numSerie;
    }

    public int getArticleCode() {
        return articleCode;
    }

    public void setArticleCode(int articleCode) {
        this.articleCode = articleCode;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.numKit);
        hash = 97 * hash + this.codeKit;
        hash = 97 * hash + (int) (this.phoneNumber ^ (this.phoneNumber >>> 32));
        hash = 97 * hash + Objects.hashCode(this.codSerie);
        hash = 97 * hash + this.articleCode;
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
        final AlComponentKit other = (AlComponentKit) obj;
        if (this.codeKit != other.codeKit) {
            return false;
        }
        if (this.phoneNumber != other.phoneNumber) {
            return false;
        }
        if (this.articleCode != other.articleCode) {
            return false;
        }
        if (!Objects.equals(this.numKit, other.numKit)) {
            return false;
        }
        if (!Objects.equals(this.codSerie, other.codSerie)) {
            return false;
        }
        return true;
    }
    
    
                            
    
}
