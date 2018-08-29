/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisintegrados.serviceivrws.dao;

import com.sisintegrados.serviceivrws.configuration.DataBaseConfiguration;
import com.sisintegrados.serviceivrws.domain.CallDetailRecord;
import javax.persistence.NoResultException;
import org.hibernate.Session;

/**
 *
 * @author MGN04582
 */
public class CallDetailRecordDaoImpl implements CallDetailRecordDao {

    @Override
    public CallDetailRecord getCallDetailRecordByMsisdn(long msisdn) {
        Session s = null;
        CallDetailRecord cdr = null;
        try{
            
            s = DataBaseConfiguration.getSessionFactory().openSession();
            s.beginTransaction();
            return (CallDetailRecord) s.createQuery("from CallDetailRecord where msisdn = :msisdn").setParameter("msisdn", msisdn).getSingleResult();
            
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

    @Override
    public void createCallDetailRecord(CallDetailRecord callDetailRecord) {
        Session s = null;
        CallDetailRecord cdr = null;
        try{
            
            s = DataBaseConfiguration.getSessionFactory().openSession();
            s.beginTransaction();
            s.save(callDetailRecord);
            s.getTransaction().commit();
            
        }catch(Exception e){
            e.printStackTrace();
            s.getTransaction().rollback();
        } finally{
            if(s.isOpen()){
                s.close();
            } 
        }
    }

    @Override
    public void updateCallDetailRecord(CallDetailRecord callDetailRecord) {
        Session s = null;
        CallDetailRecord cdr = null;
        try{
            
            s = DataBaseConfiguration.getSessionFactory().openSession();
            s.beginTransaction();
            s.update(callDetailRecord);
            s.getTransaction().commit();
            
        }catch(Exception e){
            e.printStackTrace();
            s.getTransaction().rollback();
        } finally{
            if(s.isOpen()){
                s.close();
            } 
        }
    }
    
}
