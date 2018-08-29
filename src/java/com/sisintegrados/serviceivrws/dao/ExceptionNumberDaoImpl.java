/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisintegrados.serviceivrws.dao;

import com.sisintegrados.serviceivrws.configuration.DataBaseConfiguration;
import com.sisintegrados.serviceivrws.domain.ExceptionNumber;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author MGN04582
 */
public class ExceptionNumberDaoImpl implements ExceptionNumberDao {

    @Override
    public void createExceptionNumber(ExceptionNumber exceptionNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateExceptionNumber(ExceptionNumber exceptionNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getExceptionNumberByPhoneNumber(long phoneNumber) {
        Session s = null;
        boolean isMask = false;
        try{
            s = DataBaseConfiguration.getSessionFactory().openSession();
            s.beginTransaction();    
            ExceptionNumber en = null;
            en = (ExceptionNumber) s.createQuery("from ExceptionNumber en where phoneNumber = :phoneNumber")
                    .setParameter("phoneNumber", phoneNumber)
                    .getSingleResult();
            if(en != null){
                isMask = true;
            } 
            
            return isMask;
            
        } catch(Exception e){
            return isMask;
        } finally{
            if(s.isOpen()){
                s.close();
            } 
        }
    }

    @Override
    public List<ExceptionNumber> getExceptionNumberList() {
//        DataBaseConfiguration dbc = new DataBaseConfiguration();
//        SessionFactory sf = null;
        Session s = null;
        try{
//            sf = dbc.setUp();            
            s = DataBaseConfiguration.getSessionFactory().openSession();
            s.beginTransaction();
            return s.createQuery("from ExceptionNumber").list();
            
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
