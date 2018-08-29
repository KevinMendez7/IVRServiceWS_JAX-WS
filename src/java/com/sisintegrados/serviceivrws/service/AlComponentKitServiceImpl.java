/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisintegrados.serviceivrws.service;

import com.sisintegrados.serviceivrws.dao.AlComponentKitDao;
import com.sisintegrados.serviceivrws.dao.AlComponentKitDaoImpl;
import com.sisintegrados.serviceivrws.domain.AlComponentKit;

/**
 *
 * @author MGN04582
 */
public class AlComponentKitServiceImpl implements AlComponentKitService {

    AlComponentKitDao ackd = new AlComponentKitDaoImpl();
    
    @Override
    public AlComponentKit getAlComponentKit(long msisdn) {
        return ackd.getAlComponentKit(msisdn);
    }
    
}
