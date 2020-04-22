package com.cy.hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static Configuration configuration;
    private static SessionFactory sessionFactory;

    static{
        configuration=new Configuration().configure();
        sessionFactory=configuration.buildSessionFactory();
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                sessionFactory.close();
            }
        });
    }

    public static Session openSession(){
        return sessionFactory.openSession();
    }

    public static Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
}
