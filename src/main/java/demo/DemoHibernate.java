package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.identity.SybaseAnywhereIdentityColumnSupport;
import org.hibernate.query.Query;

import domain.User;

public class DemoHibernate {

    public static void main(String[] args) {
        
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        System.out.println("CFG OK");
        Session session = sf.openSession();
        //session.beginTransaction();
        User user = new User(null, "Modsno", "123432", "modsno@nomo.com", "user");
        //session.save(user);
        //session.getTransaction().commit();
        long id = 2;
        String email = "modsno@nomo22.com";
        user = session.get(User.class, id);
//        String hql = "FROM User E WHERE E.userEmail = :user_email";
//        Query query = session.createQuery(hql);
//        query.setParameter("user_email",email);
//        User user1 = (User) query.uniqueResult();
        User user1 = (User) session.createQuery("FROM User E WHERE E.userEmail = :user_email")
                .setString("user_email", email)
                .uniqueResult();
                
        session.close();
        System.out.println(user);
        System.out.println(user1);
        System.out.println("Transaction began");
    }

}
