/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisintegrados.serviceivrws.dao;

import com.sisintegrados.serviceivrws.configuration.DataBaseConfiguration;
import com.sisintegrados.serviceivrws.domain.TransferSchedule;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author MGN04582
 */
public class TransferScheduleDaoImpl implements TransferScheduleDao {

    @Override
    public boolean getTransferScheduleByCode(short dayCode) {
//        DataBaseConfiguration dbc = new DataBaseConfiguration();
//        SessionFactory sf = null;
        Session s = null;
        boolean isAccessTime = false;
        try{
            
//            sf = dbc.setUp();
            s = DataBaseConfiguration.getSessionFactory().openSession();
            s.beginTransaction();
            TransferSchedule ts = (TransferSchedule) s.createQuery("from TransferSchedule where dayCode = :dayCode and "
                    + "startTime < to_char(sysdate,'hh24') and "
                    + "endTime > to_char(sysdate,'hh24')")
                    .setParameter("dayCode", dayCode)
                    .getSingleResult();
            if(ts != null){
                
                isAccessTime = true;
            }
            return isAccessTime;
            
        }catch(NoResultException e){            
            return isAccessTime;
        }catch(Exception e){
            e.printStackTrace();
            return isAccessTime;
        } finally{
            if(s.isOpen()){
                s.close();
            } 
        }
    }

    @Override
    public boolean getTransferSchedule(short dayCode, short time) {
//        DataBaseConfiguration dbc = new DataBaseConfiguration();
//        SessionFactory sf = null;
        Session s = null;
        boolean isAccessTime = false;
        try{
            
//            sf = dbc.setUp();
            s = DataBaseConfiguration.getSessionFactory().openSession();
            s.beginTransaction();
            TransferSchedule ts = (TransferSchedule) s.createQuery("from TransferSchedule where dayCode = :dayCode and "
                    + "startTime < :startTime and "
                    + "endTime > :endTime")
                    .setParameter("dayCode", dayCode)
                    .setParameter("startTime", time)
                    .setParameter("endTime", time)
                    .getSingleResult();
            if(ts != null){
                
                isAccessTime = true;
            }
            return isAccessTime;
            
        }catch(NoResultException e){            
            return isAccessTime;
        }catch(Exception e){
            e.printStackTrace();
            return isAccessTime;
        } finally{
            if(s.isOpen()){
                s.close();
            } 
        }
    }
    
}
