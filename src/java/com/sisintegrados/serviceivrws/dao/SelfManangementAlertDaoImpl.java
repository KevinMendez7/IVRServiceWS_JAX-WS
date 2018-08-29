/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisintegrados.serviceivrws.dao;

import com.sisintegrados.serviceivrws.configuration.DataBaseConfiguration;
import com.sisintegrados.serviceivrws.domain.SelfManangementAlert;
import org.hibernate.Session;

/**
 *
 * @author MGN04582
 */
public class SelfManangementAlertDaoImpl implements SelfManangementAlertDao {

    @Override
    public void createSelfManangementAlert(SelfManangementAlert selfManangementAlert) {
        Session s = null;
        try{
            s = DataBaseConfiguration.getSessionFactory().openSession();
            s.beginTransaction();
            s.save(selfManangementAlert);
            s.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
            s.getTransaction().rollback();
        } finally{
            
            if(s.isOpen()){
                s.close();
            }
        }
    }
    
}
