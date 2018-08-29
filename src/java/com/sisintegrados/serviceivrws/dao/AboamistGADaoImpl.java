/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisintegrados.serviceivrws.dao;

import com.sisintegrados.serviceivrws.configuration.DataBaseConfiguration;
import com.sisintegrados.serviceivrws.domain.AboamistGA;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author MGN04582
 */
public class AboamistGADaoImpl implements AboamistGADao {

    @Override
    public AboamistGA getAboamistGA(long msisdn) {
//        DataBaseConfiguration dbc = new DataBaseConfiguration();
//        SessionFactory sf = null;
        Session s = null;
        try{
//           sf = dbc.setUp(); 
           s = DataBaseConfiguration.getSessionFactory().openSession();
           s.beginTransaction();
           return (AboamistGA) s.createQuery("from AboamistGA where phoneNumber = :msisdn and situationCode != 'BAA'")
                   .setParameter("msisdn", msisdn)
                   .getSingleResult();
        }catch(NoResultException e){            
            return null;
        } catch(Exception e){
            e.printStackTrace();
            return null;
        } finally{
            if(s.isOpen()){
                s.close();
            } 
        }
    }
    
}
