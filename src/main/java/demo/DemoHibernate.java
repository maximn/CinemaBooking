package demo;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.identity.SybaseAnywhereIdentityColumnSupport;
import org.hibernate.query.Query;
import org.joda.time.DateTime;

import domain.Sessions;
import domain.Film;
import domain.User;

public class DemoHibernate {

    public static void main(String[] args) {
        
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        System.out.println("CFG OK");
        Session session = sf.openSession();
        //session.beginTransaction();
        
        
        
        Set<Sessions> set1 = new HashSet<Sessions>();
        
        
        User user = new User((long) 1, "Modsno", "123432", "modsno@nomo.com", "user");
        Film film = new Film(1, "Shadow",(Integer) 1991, "02:30", "Cool film", null);// new DateTime("yyyy-MM-dd hh:mm:ss"));
        
        
        Film filmFT = session.get(Film.class, 1);
        
        System.out.println(filmFT);
        Sessions sessions1 = new Sessions(null, new DateTime(2015, 10, 11, 13, 45), film);
        
        
        
        //session.save(sessions1);
        long id = 1;
        //session.delete(film);
        //session.getTransaction().commit();
        //long id = 1;
        String email = "modsno@nomo22.com";
        //user = session.get(User.class, id);
//        String hql = "FROM User E WHERE E.userEmail = :user_email";
//        Query query = session.createQuery(hql);
//        query.setParameter("user_email",email);
//        User user1 = (User) query.uniqueResult();
//        User user1 = (User) session.createQuery("FROM User E WHERE E.userEmail = :user_email")
//                .setString("user_email", email)
//                .uniqueResult();
                
        session.close();
        System.out.println(user);
        //System.out.println(user1);
        System.out.println("Transaction began");
    }

}
