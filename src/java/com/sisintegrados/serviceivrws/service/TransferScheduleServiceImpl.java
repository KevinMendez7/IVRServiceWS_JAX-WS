/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisintegrados.serviceivrws.service;

import com.sisintegrados.serviceivrws.dao.TransferScheduleDao;
import com.sisintegrados.serviceivrws.dao.TransferScheduleDaoImpl;
import com.sisintegrados.serviceivrws.domain.TransferSchedule;

/**
 *
 * @author MGN04582
 */
public class TransferScheduleServiceImpl implements TransferScheduleService {

    TransferScheduleDao tsd = new TransferScheduleDaoImpl();
    
    @Override
    public boolean getTransferScheduleByCode(short dayCode) {
        return tsd.getTransferScheduleByCode(dayCode);
    }

    @Override
    public boolean getTransferSchedule(short dayCode, short time) {
        return tsd.getTransferSchedule(dayCode, time);
    }
    
}
