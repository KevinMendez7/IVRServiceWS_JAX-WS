/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisintegrados.serviceivrws.dao;

import com.sisintegrados.serviceivrws.configuration.DataBaseConfiguration;
import com.sisintegrados.serviceivrws.domain.TransferRecaller;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author MGN04582
 */
public class TransferRecallerDaoImpl implements TransferRecallerDao {

    @Override
    public boolean getTransferRecaller(long msisdn) {
//        DataBaseConfiguration dbc = new DataBaseConfiguration();
//        SessionFactory sf = null;
        Session s = null;
        boolean isRecaller = false;
        try{
//           sf = dbc.setUp(); 
           s = DataBaseConfiguration.getSessionFactory().openSession();
           s.beginTransaction();           
           TransferRecaller tr = (TransferRecaller) s.createQuery("from TransferRecaller where phoneNumber = :msisdn")
                   .setParameter("msisdn", msisdn)
                   .getSingleResult();
           if(tr != null){
               isRecaller = true;
           }
           return isRecaller;
        }catch(NoResultException e){            
            return isRecaller;
        } catch(Exception e){
            e.printStackTrace();
            return isRecaller;
        } finally{
            if(s.isOpen()){
                s.close();
            } 
        }
    }
    
}
