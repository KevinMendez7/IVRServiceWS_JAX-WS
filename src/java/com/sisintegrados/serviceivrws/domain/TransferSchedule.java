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
@Table(name = "SCHEDULE_TRANSFER_IVR")
public class TransferSchedule implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SCHEDULE_TRANSFER_ID")
    private Integer scheduleId;
    
    @Column(name = "SCHEDULE_DAY")
    private String day;
    
    @Column(name = "SCHEDULE_DAY_CODE")
    private short dayCode;
    
    @Column(name = "SCHEDULE_START_TIME")
    private short startTime;
    
    @Column(name = "SCHEDULE_END_TIME")
    private short endTime;
        
    @Column(name = "SCHEDULE_SEGMENT")
    private String semgent;
    
    @Column(name = "SCHEDULE_CATEGORY")
    private String category;
    
    @Column(name = "SCHEDULE_ORIGINATOR")
    private String originator;
    
    @Column(name = "SCHEDULE_CREATION_DATE")
    private Date creationDate;
    
    @Column(name = "SCHEDULE_MODIFICATION_DATE")
    private Date modificationDate;

    public TransferSchedule() {
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public short getDayCode() {
        return dayCode;
    }

    public void setDayCode(short dayCode) {
        this.dayCode = dayCode;
    }

    public short getStartTime() {
        return startTime;
    }

    public void setStartTime(short startTime) {
        this.startTime = startTime;
    }

    public short getEndTime() {
        return endTime;
    }

    public void setEndTime(short endTime) {
        this.endTime = endTime;
    }

    public String getSemgent() {
        return semgent;
    }

    public void setSemgent(String semgent) {
        this.semgent = semgent;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.day);
        hash = 79 * hash + this.dayCode;
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
        final TransferSchedule other = (TransferSchedule) obj;
        if (!Objects.equals(this.day, other.day)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TransferSchedule{" + "scheduleId=" + scheduleId + ", day=" + day + ", dayCode=" + dayCode + ", startTime=" + startTime + ", endTime=" + endTime + ", semgent=" + semgent + ", category=" + category + ", originator=" + originator + ", creationDate=" + creationDate + ", modificationDate=" + modificationDate + '}';
    }
    
    
}
