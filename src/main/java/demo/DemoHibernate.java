package demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
        Transaction transaction = session.beginTransaction();
        
        
        
        Set<Sessions> set1 = new HashSet<Sessions>();
        
        
        User user = new User((long) 1, "Modsno", "123432", "modsno@nomo.com", "user");
        Film film = new Film(null, "Shadow",(Integer) 1991, "02:30", "Cool film", null);// new DateTime("yyyy-MM-dd hh:mm:ss"));
        Film film1 = new Film((Integer)2, "Tork",(Integer) 2001, "02:00", "Biker's Film", set1);
        
        
        //Film filmFT = session.get(Film.class, 1);
        
        //System.out.println(filmFT);
        Sessions sessions1 = new Sessions();
        Calendar sessionTime1 = new GregorianCalendar(2015, 10, 22, 11, 45);
        sessions1.setSessionsTime(sessionTime1);
        
        Sessions sessions2 = new Sessions();
        Calendar sessionTime2 = new GregorianCalendar(2016, 11, 24, 9, 45);
        sessions2.setSessionsTime(sessionTime2);
        
        Set<Sessions> sessionsSet = new HashSet<Sessions>();
        sessionsSet.add(sessions1);
        sessionsSet.add(sessions2);
        
        Film filmNew = new Film();
        filmNew.setFilmName("Shadow");
        filmNew.setFilmYear((Integer)1992);
        filmNew.setFilmLength("02:20");
        filmNew.setFilmDescription("Cool film");
        filmNew.setSessionsSet(sessionsSet);
        
        sessions1.setSessionsFilm(filmNew);
        sessions2.setSessionsFilm(filmNew);
        
      //  Sessions sessions2 = new Sessions(null, new GregorianCalendar(2015, 10, 22, 11, 45), film1);
      //  Sessions sessions3 = new Sessions(null, new GregorianCalendar(2015, 10, 23, 11, 45), film);
//        System.out.println(filmNew);
        System.out.println("------------");
        System.out.println("_____________");
 //       System.out.println(sessions1);
        
        
//        session.save(film);
//        session.getTransaction().commit();
        
        long id = 1;
        Integer id1 = 1;
        //session.delete(sessions1);
        String email = "modsno@nomo22.com";
       // User user1 = session.get(User.class, id);
        //Sessions sessions3 =(Sessions) session.get(Sessions.class, id1);
        
//   -----     session.save(film);
//        session.getTransaction().commit();
//               
//        Film film3 =(Film) session.get(Film.class, id1);
//        
//        sessions1.setSessionsFilm(film3);
//        
//        session.save(sessions1);
//   /-----     session.getTransaction().commit();
        
      //  film3.getSessionsSet().add(sessions1);
      //  session.update(film3);
      //  session.getTransaction().commit();
      
//        
//        set1 = film3.getSessionsSet();
//        for (Sessions s: set1){
//            System.out.println(s);
//            System.out.println("YA YA YA");
//        }
        
        
//        String hql = "FROM User E WHERE E.userEmail = :user_email";
//        Query query = session.createQuery(hql);
//        query.setParameter("user_email",email);
//        User user1 = (User) query.uniqueResult();
//        User user1 = (User) session.createQuery("FROM User E WHERE E.userEmail = :user_email")
//                .setString("user_email", email)
//                .uniqueResult();
        //System.out.println(sessions3);
       // System.out.println(film3);   
        session.save(filmNew);
//        session.save(sessions1);
//        session.save(sessions2);
        transaction.commit();
        Film filmDB = session.get(Film.class, 1);
        session.close();
        sf.close();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm");
        GregorianCalendar cal = new GregorianCalendar();
        Set<Sessions> set = filmDB.getSessionsSet();
        for(Sessions s: filmDB.getSessionsSet()){
            cal = (GregorianCalendar) s.getSessionsTime();
            //sdf.format(cal);
            System.out.println("Film: " + s.getSessionsFilm().getFilmName() + "   DateTime" + sdf.format(s.getSessionsTime().getTime()));
        }
        
        //System.out.println(user1);
        System.out.println("Transaction began");
    }

}
