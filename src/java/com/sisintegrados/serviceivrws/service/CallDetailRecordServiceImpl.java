/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisintegrados.serviceivrws.service;

import com.sisintegrados.serviceivrws.dao.CallDetailRecordDao;
import com.sisintegrados.serviceivrws.dao.CallDetailRecordDaoImpl;
import com.sisintegrados.serviceivrws.domain.CallDetailRecord;

/**
 *
 * @author MGN04582
 */
public class CallDetailRecordServiceImpl implements CallDetailRecordService {
    
    CallDetailRecordDao cdrd = new CallDetailRecordDaoImpl();

    @Override
    public CallDetailRecord getCallDetailRecordByMsisdn(long msisdn) {
        return cdrd.getCallDetailRecordByMsisdn(msisdn);
    }

    @Override
    public void createCallDetailRecord(CallDetailRecord callDetailRecord) {
        cdrd.createCallDetailRecord(callDetailRecord);
    }

    @Override
    public void updateCallDetailRecord(CallDetailRecord callDetailRecord) {
        cdrd.updateCallDetailRecord(callDetailRecord);
    }
    
}
