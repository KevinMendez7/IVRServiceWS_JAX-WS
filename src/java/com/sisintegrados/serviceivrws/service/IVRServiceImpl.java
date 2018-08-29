/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisintegrados.serviceivrws.service;

import com.sisintegrados.serviceivrws.domain.AboamistGA;
import com.sisintegrados.serviceivrws.domain.AbocelGA;
import com.sisintegrados.serviceivrws.domain.AlComponentKit;
import com.sisintegrados.serviceivrws.domain.AlSeries;
import com.sisintegrados.serviceivrws.domain.CallDetailRecord;
import com.sisintegrados.serviceivrws.domain.SelfManangementAlert;
import com.sisintegrados.serviceivrws.domain.SubscriberBean;
import com.sisintegrados.serviceivrws.util.Constants;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;
import javax.jws.WebService;

/**
 * This class allows implement the endpoint interface from JAX-SOAP.
 * @author Kevin Mendez
 * @version: 1.0
 */
@WebService(
        portName = "IVRServicePort",
        serviceName = "IVRService",
        targetNamespace = "http://serviceivr.sisintegrados.telefonica.com/",
        endpointInterface = "com.sisintegrados.serviceivrws.service.IVRService")
public class IVRServiceImpl implements IVRService {
         
    AbocelGAService ags = new AbocelGAServiceImpl();    
    TransferScheduleService tss = new TransferScheduleServiceImpl();
    
    /**
     * This method get the entire information from subscriber. 
     * @return: Response from all services.
     */
    public SubscriberBean getSubscriberData(long msisdn) {
        
        SubscriberBean sb = new SubscriberBean(msisdn);        
        sb.setExceptionNumber(getExceptionNumber(msisdn));    
        sb.setTransferCode("0");
        if(sb.isExceptionNumber()){
            
            return sb;
            
        } else{
            
            sb.setFreePlan(getFreePlan(msisdn));            
            if(sb.isFreePlan()){
                
                return sb;
                
            } else{
                
                sb.setSegment(getSegmentType(getSubscriberType(msisdn)));
                sb.setCategory(getSegment(msisdn));
                sb.setTransferSchedule(getTransferSchedule());
                
                if(sb.isTransferSchedule()){
                    
                    sb.setTransferRecaller(getTransferRecaller(msisdn));
                    
                    if(!sb.isTransferRecaller()){
                        
                        sb.setTransferCode(getTransferCode(sb.getSegment(),sb.getCategory()));
                        
                    }
                    
                }
                
            }
                                    
        }          
        return sb;
    }
    
    /**
     * This method get the exception number from subscriber.   
     * Numbers registred have special access inside IVR.
     * @return: Result from exception number.
     */
    public boolean getExceptionNumber(long msisdn){        
        System.out.println(msisdn);
        ExceptionNumberService ens = new ExceptionNumberServiceImpl();
        System.out.println("ExceptionNumberService: "+ens);
        return ens.getExceptionNumberByPhoneNumber(msisdn);
    }
    
    /**
     * This method get the free plan from subscriber.  
     * Numbers with basic charge registred has free access to operator
     * @return: Result from GA_ABOCEL.
     */
    public boolean getFreePlan(long msisdn){        
        return ags.getFreePlan(msisdn);
    }

    /**
     * This method get the subscriber type.  
     * Subscriber type get the tree flow from IVR.
     * @return: Result from production tables.
     */
    @Override
    public short getSubscriberType(long msisdn) {
        short usageCode;
        short centralCode;
        if(Pattern.compile("[3-4]").matcher(String.valueOf(msisdn).substring(0, 1)).find()){
            msisdn = Long.parseLong("1"+String.valueOf(msisdn));
        } 
        
        AbocelGA ag = ags.getAbocelNumber(msisdn);
        
        if(ag != null){
            
            usageCode = Integer.valueOf(ag.getUsageCode()).shortValue();
            centralCode = Integer.valueOf(ag.getCentralCode()).shortValue();
            
        }else{
            
            AboamistGAService agas = new AboamistGAServiceImpl();
            AboamistGA aga = agas.getAboamistGA(msisdn);
            
            if(aga != null){
                
                usageCode = Integer.valueOf(aga.getUsageCode()).shortValue();
                centralCode = Integer.valueOf(aga.getCentralCode()).shortValue();
                
            }else{
                
                AlSeriesService ass = new AlSeriesServiceImpl();
                AlSeries as = ass.getAlSeries(msisdn);
                
                if(as != null){
                    
                    usageCode = Integer.valueOf(as.getUseCode()).shortValue();
                    centralCode = Integer.valueOf(as.getCentralCode()).shortValue();
                    
                }else{
                    
                    AlComponentKitService acks = new AlComponentKitServiceImpl();
                    AlComponentKit ack = acks.getAlComponentKit(msisdn);
                    
                    if(ack != null){
                        
                        usageCode = Integer.valueOf(ack.getUsageCode()).shortValue();
                        centralCode = Integer.valueOf(ack.getCentralCode()).shortValue();
                        
                    }else{
                        
                        return 0;
                    }
                }
            }
        }
        
        if(usageCode==2&&String.valueOf(msisdn).substring(0, 1).equals("6")){
            
            return 1; //pospago
        
        } else if(usageCode==3&&String.valueOf(msisdn).substring(0, 1).equals("6")){
            
            return 2; //prepago
            
        } else if(usageCode==2&&String.valueOf(msisdn).substring(0, 1).equals("3")&&centralCode==3){
            
            return 3; //fixed wireless pospago
            
        } else if(usageCode==3&&String.valueOf(msisdn).substring(0, 1).equals("3")&&centralCode==3){
            
            return 4; //fixed wireless prepago
            
        } else if(usageCode==10&&String.valueOf(msisdn).substring(0, 1).equals("6")){
            
            return 5; //hibridos
            
        } else{
            
            return 0;
            
        }                                 
        
    }

    /**
     * This method get the segment from subscriber.      
     * @return: Result from segment.
     */
    @Override
    public String getSegment(long msisdn) {
        SegmentService ss = new SegmentServiceImpl();
        return ss.getSegmentationByNumber(msisdn);
    }

    /**
     * This method get the schedule whith the system date.      
     * @return: Result transfer shedule.
     */
    @Override
    public boolean getTransferSchedule() {
        short day = Integer.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_WEEK)).shortValue();        
        return tss.getTransferScheduleByCode(day);
    }

    /**
     * This method get the schedule whith added params.      
     * @return: Result transfer shedule.
     */
    @Override
    public boolean getTransferScheduleWithValues(short dayCode, short time) {
        return tss.getTransferSchedule(dayCode, time);
    }

    /**
     * This method get subscriber recallers.      
     * @return: Result transfer shedule.
     */
    @Override
    public boolean getTransferRecaller(long msisdn) {
        TransferRecallerService trs = new TransferRecallerServiceImpl();
        return trs.getTransferRecaller(msisdn);
    }
    /**
     * This method get transfer code from segment and category.     
     * @return: Result transfer shedule.
     */
    @Override
    public String getTransferCode(String segment, String category) {
        TransferCodeService tc = new TransferCodeServiceImpl();
        return tc.getTransferCode(segment, category);
    }
    
    /**
     * This method get segment type.      
     * @return: Result segment type.
     */
    public String getSegmentType(short subscriberType){
        switch(subscriberType){            
            case 1 :
                return "pospago";
            case 2 : 
                return "prepago";
            case 5 :
                return "hibrido";
            default :
                return "plan libre";
                
        }
    }   

    @Override
    public void createCallDetailRecord(long msisdn, String startDate, String transferCode, String callPath, String timePath, String packageCode, short subscriberType) {
        CallDetailRecord cdr = new CallDetailRecord(msisdn, new Date(startDate), transferCode, callPath, Constants.ORIGINATOR, timePath, packageCode, subscriberType);
        CallDetailRecordService cdrs = new CallDetailRecordServiceImpl();       
        cdrs.createCallDetailRecord(cdr);
    }

    @Override
    public void createSelfManangementAlert(String alertDescription, long msisdn, String alertOption, String alertState, String alertIVR, String alertDetail) {
        SelfManangementAlert selfManangementAlert = new SelfManangementAlert(alertDescription, msisdn, alertOption, alertState, alertIVR, alertDetail);
        SelfManangementAlertService smas = new SelfManangementAlertServiceImpl();
        smas.createSelfManangementAlert(selfManangementAlert);
    }
    
}
