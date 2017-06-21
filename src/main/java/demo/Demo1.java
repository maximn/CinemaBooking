package demo;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import connection.SeatDAOImpl;
import connection.UserDAOImpl;
import domain.Film;
import domain.Seat;
import domain.Sessions;
import domain.User;

public class Demo1 {

    public static void main(String[] args) {
        
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        System.out.println("CFG OK");
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        
//      Sessions sessions1 = new Sessions();
//      Calendar sessionTime1 = new GregorianCalendar(2017, 10, 22, 11, 40);
//      sessions1.setSessionsTime(sessionTime1);
//      
//      Sessions sessions2 = new Sessions();
//      Calendar sessionTime2 = new GregorianCalendar(2017, 11, 24, 9, 40);
//      sessions2.setSessionsTime(sessionTime2);
//      
//      Set<Sessions> sessionsSet = new HashSet<Sessions>();
//      sessionsSet.add(sessions1);
//      sessionsSet.add(sessions2);
//      
//      Film filmNew = new Film();
//      filmNew.setFilmName("Panda");
//      filmNew.setFilmYear((Integer)2009);
//      filmNew.setFilmLength("02:30");
//      filmNew.setFilmDescription("Very cool film");
//      filmNew.setSessionsSet(sessionsSet);
//      
//      sessions1.setSessionsFilm(filmNew);
//      sessions2.setSessionsFilm(filmNew);
        
        Film film2 = session.get(Film.class, 4);
      
    session.delete(film2);
    session.getTransaction().commit();
        
        
    
//        SeatDAOImpl seatDAO = new SeatDAOImpl();
//       
//       Seat seat = new Seat();
//       Integer id = 3;
//       seat = seatDAO.findId(id);
//       seat.setSeatRow(16);
//       seatDAO.update(seat);
       
      // userDAO.deleteByEmail(user);
       
       
      // System.out.println(userDAO.existEmail("frad@frad.com") + "\n" + userDAO.findEmail("frad@frad.com"));
       //System.out.println(userDAO.findEmail("Gamlet@Gamlet.com"));
       
      //userDAO.closeSessionFactory();
        
       

    }

}
