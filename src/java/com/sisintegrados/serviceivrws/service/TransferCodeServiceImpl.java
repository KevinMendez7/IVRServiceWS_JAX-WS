/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisintegrados.serviceivrws.service;

import com.sisintegrados.serviceivrws.dao.TransferCodeDao;
import com.sisintegrados.serviceivrws.dao.TransferCodeDaoImpl;

/**
 *
 * @author MGN04582
 */
public class TransferCodeServiceImpl implements TransferCodeService {

    TransferCodeDao tcd = new TransferCodeDaoImpl();
    
    @Override
    public String getTransferCode(String segment, String category) {
        return tcd.getTransferCode(segment, category);
    }
    
}
