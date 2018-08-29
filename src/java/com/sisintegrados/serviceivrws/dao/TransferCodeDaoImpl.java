/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisintegrados.serviceivrws.dao;

import com.sisintegrados.serviceivrws.configuration.DataBaseConfiguration;
import com.sisintegrados.serviceivrws.domain.TransferCode;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author MGN04582
 */
public class TransferCodeDaoImpl implements TransferCodeDao {

    @Override
    public String getTransferCode(String segment, String category) {
//        segment.toUpperCase();
//        category.toUpperCase();
        Session s = null;
        String code = "+1527";
        try{
//            sf = dbc.setUp();
            s = DataBaseConfiguration.getSessionFactory().openSession();
            s.beginTransaction();
            TransferCode tc = (TransferCode) s.createQuery("from TransferCode where upper(segment) = :segment and upper(category) = :category")
                    .setParameter("segment", segment.toUpperCase())
                    .setParameter("category", category.toUpperCase())
                    .getSingleResult();
            if(tc!=null){
                code = tc.getCode();
            }
            
            return code;
            
        }catch(NoResultException e){            
            return code;
        }catch(Exception e){
            e.printStackTrace();
            return code;
        } finally{
            if(s.isOpen()){
                s.close();
            } 
        }
    }
    
}
