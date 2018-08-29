/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisintegrados.serviceivrws.domain;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "MASK_IVR")
public class ExceptionNumber implements Serializable {
    
    public static long SerialVersionUID = 474646377373L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MASK_ID")
    private Integer id;
    
    @Column(name = "PHONE_NUMBER")
    private long phoneNumber;
    
    @Column(name = "REQUESTED_NAME")
    private String requestName;
    
    @Column(name = "CREATION_DATE")
    private Date dateCreated;
    
    @Column(name = "ORIGINATOR_NAME")
    private String creatorName;
    
    public ExceptionNumber() {
    }

    public ExceptionNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (this.phoneNumber ^ (this.phoneNumber >>> 32));
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
        final ExceptionNumber other = (ExceptionNumber) obj;
        if (this.phoneNumber != other.phoneNumber) {
            return false;
        }
        return true;
    }
    
    
    
}
