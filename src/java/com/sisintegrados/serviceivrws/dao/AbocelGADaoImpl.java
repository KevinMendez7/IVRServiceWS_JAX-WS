/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisintegrados.serviceivrws.dao;

import com.sisintegrados.serviceivrws.configuration.DataBaseConfiguration;
import com.sisintegrados.serviceivrws.domain.AbocelGA;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author MGN04582
 */
public class AbocelGADaoImpl implements AbocelGADao {

    @Override
    public AbocelGA getAbocelNumber(long msisdn) {
//        DataBaseConfiguration dbc = new DataBaseConfiguration();
//        SessionFactory sf = null;
        Session s = null;
        try{
//           sf = dbc.setUp(); 
           s = DataBaseConfiguration.getSessionFactory().openSession();
           s.beginTransaction();
           return (AbocelGA) s.createQuery("from AbocelGA where phoneNumber = :msisdn and situationCode != 'BAA'")
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
//            sf.close();
//            dbc.shutdown();
        }
        
    }

    @Override
    public boolean getFreePlan(long msisdn) {
//        DataBaseConfiguration dbc = new DataBaseConfiguration();
//        SessionFactory sf = null;
        Session s = null;
        AbocelGA aga = null;
        boolean isFreePlan = false;
        try{
            
//            sf = dbc.setUp();
            s = DataBaseConfiguration.getSessionFactory().openSession();
            s.beginTransaction();
            aga = (AbocelGA) s.createQuery("from AbocelGA where num_celular = :msisdn  and cod_situacion = 'AAA' and cod_cargobasico in( '3S0' , '2S7' , '1S4' , '1S3' , '3S3' , '3S5' )")
                    .setParameter("msisdn", msisdn)
                    .getSingleResult();
            if(aga != null){
                
                isFreePlan = true;
            }
            return isFreePlan;
            
        } catch(Exception e){
            return isFreePlan;
            
        } finally{
            if(s.isOpen()){
                s.close();
            }
        }
    }
    
}
