/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisintegrados.serviceivrws.dao;

import com.sisintegrados.serviceivrws.domain.TransferSchedule;

/**
 *
 * @author MGN04582
 */
public interface TransferScheduleDao {
    
    boolean getTransferScheduleByCode(short dayCode);
    
    boolean getTransferSchedule(short dayCode, short time);
    
}
