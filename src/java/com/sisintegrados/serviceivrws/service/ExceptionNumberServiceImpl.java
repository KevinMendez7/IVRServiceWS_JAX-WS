/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisintegrados.serviceivrws.service;

import com.sisintegrados.serviceivrws.dao.ExceptionNumberDao;
import com.sisintegrados.serviceivrws.dao.ExceptionNumberDaoImpl;
import com.sisintegrados.serviceivrws.domain.ExceptionNumber;
import java.util.List;

/**
 *
 * @author MGN04582
 */
public class ExceptionNumberServiceImpl implements ExceptionNumberService {
    
    ExceptionNumberDao ensd = new ExceptionNumberDaoImpl();

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
        System.out.println("Service impl :"+phoneNumber);
        return ensd.getExceptionNumberByPhoneNumber(phoneNumber);
    }

    @Override
    public List<ExceptionNumber> getExceptionNumberList() {
        return ensd.getExceptionNumberList();
    }
    
}
