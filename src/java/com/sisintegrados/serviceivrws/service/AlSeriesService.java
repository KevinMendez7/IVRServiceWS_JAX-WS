/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisintegrados.serviceivrws.service;

import com.sisintegrados.serviceivrws.domain.AlSeries;

/**
 *
 * @author MGN04582
 */
public interface AlSeriesService {
    
    AlSeries getAlSeries(long msisdn);
    
}
