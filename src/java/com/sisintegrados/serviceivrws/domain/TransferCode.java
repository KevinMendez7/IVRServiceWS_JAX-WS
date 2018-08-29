/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisintegrados.serviceivrws.domain;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "SKILL_TRANSFER_IVR")
public class TransferCode implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SKILL_ID")
    private Integer transferId;
    
    @Column(name = "SKILL_CATEGORY")
    private String category;
    
    @Column(name = "SKILL_SEGMENT")
    private String segment;
    
    @Column(name = "SKILL_CODE")
    private String code;
    
    @Column(name = "SKILL_ORIGINATOR")
    private String originator;
    
    @Column(name = "SKILL_CREATION_DATE")
    private Date creationDate;

    public TransferCode() {
    }

    public Integer getTransferId() {
        return transferId;
    }

    public void setTransferId(Integer transferId) {
        this.transferId = transferId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String Category) {
        this.category = Category;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String Segment) {
        this.segment = Segment;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String Code) {
        this.code = Code;
    }

    public String getOriginator() {
        return originator;
    }

    public void setOriginator(String originator) {
        this.originator = originator;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.category);
        hash = 61 * hash + Objects.hashCode(this.segment);
        hash = 61 * hash + Objects.hashCode(this.code);
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
        final TransferCode other = (TransferCode) obj;
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        if (!Objects.equals(this.segment, other.segment)) {
            return false;
        }
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TransferCode{" + "transferId=" + transferId + ", category=" + category + ", segment=" + segment + ", code=" + code + ", originator=" + originator + ", creationDate=" + creationDate + '}';
    }
    
    
  
}
