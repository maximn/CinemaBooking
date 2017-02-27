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

import domain.Film;
import domain.Seat;
import domain.Sessions;
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
        
        
        
//        Sessions sessions1 = new Sessions();
//        Calendar sessionTime1 = new GregorianCalendar(2015, 10, 22, 11, 45);
//        sessions1.setSessionsTime(sessionTime1);
//        
//        Sessions sessions2 = new Sessions();
//        Calendar sessionTime2 = new GregorianCalendar(2016, 11, 24, 9, 45);
//        sessions2.setSessionsTime(sessionTime2);
//        
//        Set<Sessions> sessionsSet = new HashSet<Sessions>();
//        sessionsSet.add(sessions1);
//        sessionsSet.add(sessions2);
//        
//        Film filmNew = new Film();
//        filmNew.setFilmName("Shadow");
//        filmNew.setFilmYear((Integer)1992);
//        filmNew.setFilmLength("02:20");
//        filmNew.setFilmDescription("Cool film");
//        filmNew.setSessionsSet(sessionsSet);
//        
//        sessions1.setSessionsFilm(filmNew);
//        sessions2.setSessionsFilm(filmNew);
//        
//      session.save(filmNew);
//      session.getTransaction().commit();
        
        
        
                
      //  Sessions sessions2 = new Sessions(null, new GregorianCalendar(2015, 10, 22, 11, 45), film1);
      //  Sessions sessions3 = new Sessions(null, new GregorianCalendar(2015, 10, 23, 11, 45), film);

        System.out.println("------------");
        System.out.println("_____________");
 
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
       
     //---------first commit film's object   
//        session.save(filmNew);
//        transaction.commit();
        
        
        
        
        
//        Set<Sessions> sessionsSet1 = new HashSet<Sessions>();
//        Set<Sessions> sessionsSet2 = new HashSet<Sessions>();
//        
//        Set<Seat> seatsSet1 = new HashSet<Seat>();
//        Set<Seat> seatsSet2 = new HashSet<Seat>();
       
// --3--       
//       Sessions sess1 = session.get(Sessions.class, 1);
//       Sessions sess2 = session.get(Sessions.class, 2);
//      
//        
//        Seat seat1 = session.get(Seat.class, 4);
//        Seat seat2 = session.get(Seat.class, 5);
//        Seat seat3 = session.get(Seat.class, 6);
//        
//        sess1.getSessionsSeats().add(seat1);
//        sess1.getSessionsSeats().add(seat3);
//        sess2.getSessionsSeats().add(seat1);
//       
//        seat1.getSessions().add(sess1);
//        seat1.getSessions().add(sess2);
//        seat3.getSessions().add(sess1);
        
//--3--       
//      Sessions sess1 = session.get(Sessions.class, 1);
//      Sessions sess2 = session.get(Sessions.class, 2);
//        
//      Seat seat1 = session.get(Seat.class, 1);
//      Seat seat2 = session.get(Seat.class, 2);
//      Seat seat3 = session.get(Seat.class, 3);
//  ----------    
      
//            Seat seat1 = new Seat();
//      seat1.setSeatNum(22);
//      seat1.setSeatRow(10);
//      seat1.setSeatHall("Yellow Hall");
//      seat1.setSeatStatus("reserved");
//      
//      
//      Seat seat2 = new Seat();
//      seat2.setSeatNum(23);
//      seat2.setSeatRow(10);
//      seat2.setSeatHall("Brown Hall");
//      seat2.setSeatStatus("reserved");
//      
//      Seat seat3 = new Seat();
//      seat3.setSeatNum(24);
//      seat3.setSeatRow(15);
//      seat3.setSeatHall("Yellow Hall");
//      seat3.setSeatStatus("reserved");
      
//----------------
//              sess1.addSeat(seat1);
//      sess1.addSeat(seat3);
//      sess2.addSeat(seat2);
////      
//      seat1.addSessions(sess1);
//      seat2.addSessions(sess2);
//      seat3.addSessions(sess1);
////      
//      session.saveOrUpdate(seat1);
//      session.saveOrUpdate(seat2);
//      session.saveOrUpdate(seat3);
////      
////      
//      session.saveOrUpdate(sess1);
//      session.saveOrUpdate(sess2);
      
      Sessions sessions1 = new Sessions();
    Calendar sessionTime1 = new GregorianCalendar(2014, 10, 22, 11, 45);
    sessions1.setSessionsTime(sessionTime1);
    
    Seat seat = new Seat();
    seat.setSeatNum(3);
    seat.setSeatHall("Yellow Hall");
    seat.setSeatRow(5);
    seat.setSeatStatus("reserved");
    seat.addSessions(sessions1);
    
    sessions1.addSeat(seat);
    
    Film filmBB = session.get(Film.class, 1);
    
    filmBB.getSessionsSet().add(sessions1);
    
    session.saveOrUpdate(filmBB);
//      
      session.getTransaction().commit();
  //---------------------------    
        
        
//        sessionsSet1.add(sess1);
//        sessionsSet1.add(sess2);
//        sessionsSet2.add(sess2);
//        
//        seatsSet1.add(seat1);
//        seatsSet1.add(seat3);
//        seatsSet2.add(seat1);
//        
//        sess1.setSessionsSeats(seatsSet1);
//        sess2.setSessionsSeats(seatsSet2);
//        
//        seat1.setSessions(sessionsSet1);
//        seat3.setSessions(sessionsSet2);
        
//        Seat seat1 = new Seat();
//        seat1.setSeatNum(22);
//        seat1.setSeatRow(10);
//        seat1.setSeatHall("Yellow Hall");
//        seat1.setSeatStatus("reserved");
//        seat1.setSessions(sessionsSet1);
////        
//        Seat seat2 = new Seat();
//        seat2.setSeatNum(23);
//        seat2.setSeatRow(10);
//        seat2.setSeatHall("Brown Hall");
//        seat2.setSeatStatus("reserved");
//        seat2.setSessions(sessionsSet2);
////        
//        Seat seat3 = new Seat();
//        seat3.setSeatNum(24);
//        seat3.setSeatRow(15);
//        seat3.setSeatHall("Yellow Hall");
//        seat3.setSeatStatus("reserved");
//        seat3.setSessions(sessionsSet1);
//        

        
//        session.update(seat1);
//        session.update(seat2);
//        session.update(seat3);
//        
//        session.update(sess1);
//        session.update(sess2);
        
        
//        session.getTransaction().commit();
        
        
        
        Film filmDB = session.get(Film.class, 1);
//        Seat seatDB = session.get(Seat.class, 1);
        
        
        session.close();
        sf.close();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm");
        GregorianCalendar cal = new GregorianCalendar();
        Set<Sessions> set = filmDB.getSessionsSet();
        for(Sessions s: filmDB.getSessionsSet()){
            System.out.println("Film: " + s.getSessionsFilm().getFilmName() + "   DateTime" + sdf.format(s.getSessionsTime().getTime()));
        }
        
//        for(Sessions s: seatDB.getSessions()){
//            System.out.println("Sessions Film name of the seat:  " + s.getSessionsFilm().getFilmName() + "  Session's Time: " + sdf.format(s.getSessionsTime().getTime()));
//        }
        //System.out.println(user1);
        System.out.println("Transaction began");
    }

}
