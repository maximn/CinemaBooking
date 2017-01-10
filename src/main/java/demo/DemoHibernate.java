package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DemoHibernate {

    public static void main(String[] args) {
        
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        System.out.println("CFG OK");
        Session session = sf.openSession();
        session.beginTransaction();
        System.out.println("Transaction began");
    }

}
