/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisintegrados.serviceivrws.service;

import com.sisintegrados.serviceivrws.dao.SegmentDao;
import com.sisintegrados.serviceivrws.dao.SegmentDaoImpl;
import com.sisintegrados.serviceivrws.domain.Segment;

/**
 *
 * @author MGN04582
 */
public class SegmentServiceImpl implements SegmentService {
    
    private SegmentDao sd = new SegmentDaoImpl();

    @Override
    public String getSegmentationByNumber(long msisdn) {
        String segment = "Azul";
        Segment s = sd.getSegmentationByNumber(msisdn);
        
        if(s != null){
            
            if(s.getSubscriberType().equals("J")){
            
                segment = "PYME";
            
            } else if (s.getSubscriberType().equals("GE")){
            
                segment = "GRANDE EMPRESA";
                
            } else{
                
                segment = s.getClassification();
            }
        }        
        
        return segment;
    }
    
}
