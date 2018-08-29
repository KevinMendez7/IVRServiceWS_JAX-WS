/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisintegrados.serviceivrws.service;

import com.sisintegrados.serviceivrws.dao.TransferRecallerDao;
import com.sisintegrados.serviceivrws.dao.TransferRecallerDaoImpl;

/**
 *
 * @author MGN04582
 */
public class TransferRecallerServiceImpl implements TransferRecallerService {
    
    TransferRecallerDao trd = new TransferRecallerDaoImpl();

    @Override
    public boolean getTransferRecaller(long msisdn) {
        return trd.getTransferRecaller(msisdn);
    }
    
}
