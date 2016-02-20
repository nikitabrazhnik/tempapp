/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tempapp;

import com.nbr.testhibernate.model.User;
import java.util.Random;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author macb
 */
public class TempApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rnd = new Random();

        //---
        Configuration cnf = new Configuration();
        cnf.configure();
        ServiceRegistry srv = new StandardServiceRegistryBuilder().applySettings(cnf.getProperties()).build();;
        SessionFactory sfac = cnf.buildSessionFactory(srv);
//---

        //Session sf = DAOclass.getSessionFactory().getCurrentSession();
        for (int i = 0; i < 10; i++) {
            Session sf = sfac.getCurrentSession();
            sf.beginTransaction();

            User usr = new User();
            usr.setLogin(Integer.toString(i));
            usr.setEmail("nikita.brazhnik@gmail.com");
            usr.setLoginType("1");
            usr.setName(Long.toString(rnd.nextLong()));
            sf.save(usr);
            sf.getTransaction().commit();
        }

    }

}
