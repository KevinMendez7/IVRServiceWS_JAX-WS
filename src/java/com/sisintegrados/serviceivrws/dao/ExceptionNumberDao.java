/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisintegrados.serviceivrws.dao;

import com.sisintegrados.serviceivrws.domain.ExceptionNumber;
import java.util.List;

/**
 *
 * @author MGN04582
 */
public interface ExceptionNumberDao {
    
    void createExceptionNumber(ExceptionNumber exceptionNumber);
    
    void updateExceptionNumber(ExceptionNumber exceptionNumber);
    
    boolean getExceptionNumberByPhoneNumber(long phoneNumber);
    
    List<ExceptionNumber> getExceptionNumberList();
            
}
