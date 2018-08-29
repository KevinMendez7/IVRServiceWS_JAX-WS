/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisintegrados.serviceivrws.dao;

import com.sisintegrados.serviceivrws.configuration.DataBaseConfiguration;
import com.sisintegrados.serviceivrws.domain.Segment;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author MGN04582
 */
public class SegmentDaoImpl implements SegmentDao {

    @Override
    public Segment getSegmentationByNumber(long phoneNumber) {
        Session s = null;
        try{
            s = DataBaseConfiguration.getSessionFactory().openSession();
            s.beginTransaction();
            return (Segment) s.createQuery("from Segment where phoneNumber = :phoneNumber")
                    .setParameter("phoneNumber", phoneNumber)
                    .getSingleResult();
            
        } catch(NoResultException e){            
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
