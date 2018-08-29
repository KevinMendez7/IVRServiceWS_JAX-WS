/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisintegrados.serviceivrws.service;

import com.sisintegrados.serviceivrws.dao.AboamistGADao;
import com.sisintegrados.serviceivrws.dao.AboamistGADaoImpl;
import com.sisintegrados.serviceivrws.domain.AboamistGA;

/**
 *
 * @author MGN04582
 */
public class AboamistGAServiceImpl implements AboamistGAService {
    
    AboamistGADao ags = new AboamistGADaoImpl();

    @Override
    public AboamistGA getAboamistGA(long msisdn) {
        return ags.getAboamistGA(msisdn);
    }
    
}
