/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisintegrados.serviceivrws.service;

import com.sisintegrados.serviceivrws.dao.AbocelGADaoImpl;
import com.sisintegrados.serviceivrws.domain.AbocelGA;
import com.sisintegrados.serviceivrws.dao.AbocelGADao;

/**
 *
 * @author MGN04582
 */
public class AbocelGAServiceImpl implements AbocelGAService {
    
    private AbocelGADao gad = new AbocelGADaoImpl();

    @Override
    public AbocelGA getAbocelNumber(long phoneNumber) {
        return gad.getAbocelNumber(phoneNumber);
    }

    @Override
    public boolean getFreePlan(long msisdn) {
        return gad.getFreePlan(msisdn);
    }
    
}
