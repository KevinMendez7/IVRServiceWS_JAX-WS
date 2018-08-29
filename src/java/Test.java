

import com.sisintegrados.serviceivrws.service.ExceptionNumberService;
import com.sisintegrados.serviceivrws.service.ExceptionNumberServiceImpl;
import com.sisintegrados.serviceivrws.service.IVRService;
import com.sisintegrados.serviceivrws.service.IVRServiceImpl;
import com.sisintegrados.serviceivrws.service.TransferCodeService;
import com.sisintegrados.serviceivrws.service.TransferCodeServiceImpl;
import com.sisintegrados.serviceivrws.service.TransferRecallerService;
import com.sisintegrados.serviceivrws.service.TransferRecallerServiceImpl;
import java.util.Calendar;
import java.util.Date;
import javax.xml.ws.Endpoint;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author MGN04582
 */
public class Test {

    public static void main(String[] ar) {
        
        Endpoint ep = Endpoint.create(new IVRServiceImpl());
        ep.publish("http://127.0.0.1:10000/IVRService");

                
//        System.out.println(is.getExceptionNumber(50243943531L));
        
       
        
        
        
        
        

    }

}
