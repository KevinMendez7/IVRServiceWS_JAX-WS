/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisintegrados.serviceivrws.configuration;

import com.sisintegrados.serviceivrws.domain.AboamistGA;
import com.sisintegrados.serviceivrws.domain.ExceptionNumber;
import com.sisintegrados.serviceivrws.domain.AbocelGA;
import com.sisintegrados.serviceivrws.domain.AlComponentKit;
import com.sisintegrados.serviceivrws.domain.AlSeries;
import com.sisintegrados.serviceivrws.domain.Segment;
import com.sisintegrados.serviceivrws.domain.TransferCode;
import com.sisintegrados.serviceivrws.domain.TransferRecaller;
import com.sisintegrados.serviceivrws.domain.TransferSchedule;
import com.sisintegrados.serviceivrws.domain.CallDetailRecord;
import com.sisintegrados.serviceivrws.domain.SelfManangementAlert;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.boot.Metadata;
import org.hibernate.cfg.Environment;

/**
 *
 * @author MGN04582
 */
public class DataBaseConfiguration {
    
    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry registry;

    private static Map<String, String> getProperties() {
        // Hibernate settings equivalent to hibernate.cfg.xml's properties
        Map<String, String> settings = new HashMap<>();
        settings.put(Environment.DRIVER, "oracle.jdbc.OracleDriver");
        settings.put(Environment.URL, "jdbc:oracle:thin:@//******:1521/******");
        settings.put(Environment.USER, "*****");
        settings.put(Environment.PASS, "*****");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.OracleDialect");
        settings.put(Environment.DEFAULT_SCHEMA, "******");
        settings.put(Environment.SHOW_SQL, "true");
        return settings;
    }

    private static StandardServiceRegistry getRegistry() {

        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
        // Apply settings                
        registryBuilder.applySettings(getProperties());

        // Create registry
        registry = registryBuilder.build();
        return registry;
    }

    // Create MetadataSources
    private static MetadataSources getSources() {        
        MetadataSources sources = new MetadataSources(getRegistry());           
        sources.addAnnotatedClass(AlSeries.class);
        sources.addAnnotatedClass(ExceptionNumber.class);
        sources.addAnnotatedClass(AbocelGA.class);
        sources.addAnnotatedClass(AboamistGA.class);
        sources.addAnnotatedClass(Segment.class);
        sources.addAnnotatedClass(TransferSchedule.class);        
        sources.addAnnotatedClass(TransferCode.class);
        sources.addAnnotatedClass(AlComponentKit.class);
        sources.addAnnotatedClass(TransferRecaller.class);
        sources.addAnnotatedClass(CallDetailRecord.class);
        sources.addAnnotatedClass(SelfManangementAlert.class);
        return sources;
    }
    
//    public SessionFactory setUp() throws Exception {
//        if (sessionFactory == null) {
    static{
        
        try {               
                // Create Metadata
                Metadata metadata = getSources().getMetadataBuilder().build();

                // Create SessionFactory                    
                sessionFactory = metadata.getSessionFactoryBuilder().build();

            } catch (Exception e) {
                e.printStackTrace();
                // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
                // so destroy it manually.
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
    }

    public static SessionFactory getSessionFactory(){
        
        return sessionFactory;
    }
            

//        }
        // A SessionFactory is set up once for an application!        

//        return sessionFactory;
//    }

    public void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
    
}
