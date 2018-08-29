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
@Table(name = "SEGMENT_IVR")
public class Segment implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEGMENT_ID")
    private Integer segmentId;
    
    @Column(name = "PHONE_NUMBER")
    private long phoneNumber;
    
    @Column(name = "CLASSIFICATION")
    private String classification;
    
    @Column(name = "SUBSCRIBER_TYPE")
    private String subscriberType;
    
    @Column(name = "CREATION_DATE")
    private Date creationDate;
    
    public Segment(){
        
    }

    public Integer getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(Integer segmentId) {
        this.segmentId = segmentId;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getSubscriberType() {
        return subscriberType;
    }

    public void setSubscriberType(String subscriberType) {
        this.subscriberType = subscriberType;
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
        hash = 53 * hash + (int) (this.phoneNumber ^ (this.phoneNumber >>> 32));
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
        final Segment other = (Segment) obj;
        if (this.phoneNumber != other.phoneNumber) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Segment{" + "segmentId=" + segmentId + ", phoneNumber=" + phoneNumber + ", classification=" + classification + ", subscriberType=" + subscriberType + ", creationDate=" + creationDate + '}';
    }
    
    
    
}
