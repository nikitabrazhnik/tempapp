/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbr.testhibernate.controller;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author brazhnik
 */
public class DAOclass {

    private static SessionFactory sf;

    private DAOclass() {
        Configuration cnf = new Configuration();
        cnf.configure("hibernate.cfg");
        ServiceRegistry srv = new StandardServiceRegistryBuilder().applySettings(cnf.getProperties()).build();;
        sf = cnf.buildSessionFactory(srv);

    }

    public static SessionFactory getSessionFactory() {
        return sf;
    }

    public static DAOclass getInstance() {
        return DAOclassHolder.INSTANCE;
    }

    private static class DAOclassHolder {

        private static final DAOclass INSTANCE = new DAOclass();

    }
}
