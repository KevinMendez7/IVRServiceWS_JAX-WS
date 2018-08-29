/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisintegrados.serviceivrws.service;

import com.sisintegrados.serviceivrws.dao.SelfManangementAlertDao;
import com.sisintegrados.serviceivrws.dao.SelfManangementAlertDaoImpl;
import com.sisintegrados.serviceivrws.domain.SelfManangementAlert;

/**
 *
 * @author MGN04582
 */
public class SelfManangementAlertServiceImpl implements SelfManangementAlertService {
    
    SelfManangementAlertDao smad = new SelfManangementAlertDaoImpl();

    @Override
    public void createSelfManangementAlert(SelfManangementAlert selfManangementAlert) {
        smad.createSelfManangementAlert(selfManangementAlert);
    }
    
}
