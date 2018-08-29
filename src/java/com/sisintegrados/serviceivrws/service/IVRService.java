/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisintegrados.serviceivrws.service;

import com.sisintegrados.serviceivrws.domain.SubscriberBean;
import java.util.Date;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author MGN04582
 */
@WebService
        (
    name = "IVRService" ,
    targetNamespace = "http://serviceivr.sisintegrados.telefonica.com/")
public interface IVRService {
    
    @WebMethod
    @WebResult(name = "getSubscriberDataResponse")
    SubscriberBean getSubscriberData(@WebParam(name = "msisdn") @XmlElement(required = true, nillable = true) long msisdn);
    
    @WebMethod
    @WebResult(name = "getExceptionNumberResponse")
    boolean getExceptionNumber(@WebParam(name = "msisdn") @XmlElement(required = true, nillable = false) long msisdn);
    
    @WebMethod
    @WebResult(name = "getFreePlanResponse")
    boolean getFreePlan(@WebParam(name = "msisdn") @XmlElement(required = true, nillable = false) long msisdn);
    
    @WebMethod
    @WebResult(name = "getSubscriberTypeResponse")
    short getSubscriberType(@WebParam(name = "msisdn") @XmlElement(required = true, nillable = false) long msisdn);
    
    @WebMethod
    @WebResult(name = "getSegmentResponse")
    String getSegment(@WebParam(name = "msisdn") @XmlElement(required = true, nillable = false) long msisdn);
    
    @WebMethod
    @WebResult(name = "getTransferScheduleResponse")
    boolean getTransferSchedule();
    
    @WebMethod
    @WebResult(name = "getTransferScheduleWithValuesResponse")
    boolean getTransferScheduleWithValues(@WebParam(name = "dayCode") @XmlElement(required = true, nillable = false) short dayCode,
                                          @WebParam(name = "time") @XmlElement(required = true, nillable = false) short time);
    
    @WebMethod
    @WebResult(name = "getTransferRecallerResponse")
    boolean getTransferRecaller(@WebParam(name = "msisdn") @XmlElement(required = true, nillable = false) long msisdn);
    
    @WebMethod
    @WebResult(name = "getTransferCodeResponse")
    String getTransferCode(@WebParam(name = "segment") @XmlElement(required = true, nillable = false) String segment, 
                           @WebParam(name = "category") @XmlElement(required = true, nillable = false) String category);
    
    @WebMethod
    void createCallDetailRecord(@WebParam(name = "msisdn") @XmlElement(required = true, nillable = false) long msisdn, 
                                @WebParam(name = "startDate") @XmlElement(required = true, nillable = false) String startDate, 
                                @WebParam(name = "transferCode") @XmlElement(required = true, nillable = false) String transferCode, 
                                @WebParam(name = "callPath") @XmlElement(required = true, nillable = false) String callPath, 
                                @WebParam(name = "timePath") @XmlElement(required = true, nillable = false) String timePath, 
                                @WebParam(name = "packageCode") @XmlElement(required = true, nillable = false) String packageCode, 
                                @WebParam(name = "subscriberType") @XmlElement(required = true, nillable = false) short subscriberType);
    
    @WebMethod
    void createSelfManangementAlert(@WebParam(name = "alertDescription") @XmlElement(required = true, nillable = false) String alertDescription, 
                                    @WebParam(name = "msisdn") @XmlElement(required = true, nillable = false) long msisdn, 
                                    @WebParam(name = "alertOption") @XmlElement(required = true, nillable = false) String alertOption,
                                    @WebParam(name = "alertState") @XmlElement(required = true, nillable = false) String alertState,
                                    @WebParam(name = "alertIVR") @XmlElement(required = true, nillable = false) String alertIVR,
                                    @WebParam(name = "alertDetail") @XmlElement(required = true, nillable = false) String alertDetail);
    
}
