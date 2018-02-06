package com.otoil.ot_118_rest.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Created by Ageev Evgeny on 01.02.2018.
 */
public class Hibernate {
//    private static SessionFactory sessionFactory;
//
//    static {
//        Configuration cfg = new Configuration().configure();
//        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
//                .applySettings(cfg.getProperties());
//        sessionFactory = cfg.buildSessionFactory(builder.build());
//    }
//
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }

    private static SessionFactory sessionFactory = buildSessionFactory();

    protected static SessionFactory buildSessionFactory() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );

            throw new ExceptionInInitializerError("Initial SessionFactory failed" + e);
        }
        return sessionFactory;
    }


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
