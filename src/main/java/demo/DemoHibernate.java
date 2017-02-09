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
import domain.Seat;
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
        
        Set<Sessions> sessionsSet1 = new HashSet<Sessions>();
        Set<Sessions> sessionsSet2 = new HashSet<Sessions>();
        sessionsSet1.add(sessions1);
        sessionsSet1.add(sessions2);
        sessionsSet2.add(sessions2);
        Seat seat1 = new Seat();
        seat1.setSeatNum(22);
        seat1.setSeatRow(10);
        seat1.setSeatHall("Yellow Hall");
        seat1.setSeatStatus("reserved");
        seat1.setSessions(sessionsSet1);
        
        Seat seat2 = new Seat();
        seat2.setSeatNum(23);
        seat2.setSeatRow(10);
        seat2.setSeatHall("Brown Hall");
        seat2.setSeatStatus("reserved");
        seat2.setSessions(sessionsSet2);
        
        Seat seat3 = new Seat();
        seat3.setSeatNum(24);
        seat3.setSeatRow(15);
        seat3.setSeatHall("Yellow Hall");
        seat3.setSeatStatus("reserved");
        seat3.setSessions(sessionsSet1);
        
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
        session.save(seat1);
        session.save(seat2);
        session.save(seat3);
//        session.save(sessions1);
//        session.save(sessions2);
        transaction.commit();
        Film filmDB = session.get(Film.class, 1);
        Seat seatDB = session.get(Seat.class, 1);
        session.close();
        sf.close();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm");
        GregorianCalendar cal = new GregorianCalendar();
        Set<Sessions> set = filmDB.getSessionsSet();
        for(Sessions s: filmDB.getSessionsSet()){
            System.out.println("Film: " + s.getSessionsFilm().getFilmName() + "   DateTime" + sdf.format(s.getSessionsTime().getTime()));
        }
        
        for(Sessions s: seatDB.getSessions()){
            System.out.println("Sessions Film name of the seat:  " + s.getSessionsFilm().getFilmName() + "  Session's Time: " + sdf.format(s.getSessionsTime().getTime()));
        }
        //System.out.println(user1);
        System.out.println("Transaction began");
    }

}
