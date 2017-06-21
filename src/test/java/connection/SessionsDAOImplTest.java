package connection;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.Sessions;

public class SessionsDAOImplTest {
    
    private static SessionsDAOImpl sessionDAO = new SessionsDAOImpl();
    
    @BeforeClass
    public static void beforeTests() {
        Sessions sessions1 = new Sessions();
        Calendar sessionTime1 = new GregorianCalendar(2015, 10, 22, 11, 45);
        sessions1.setSessionsTime(sessionTime1);
        
        sessionDAO.createSession(sessions1);
    }
    
    @Test
    public void findIdTest(){
        Sessions sessionTest1 = sessionDAO.findId(1);
        Calendar sessionTime1 = new GregorianCalendar(2017, 10, 22, 11, 45);
        assertTrue(sessionTest1.getSessionsTime().equals(sessionTime1));
    }
    
    @Test
    public void listTest(){
        List<Sessions> list = sessionDAO.list();
        Calendar sessionTime1 = new GregorianCalendar(2017, 10, 22, 11, 45);
        assertTrue(list.get(0).getSessionsTime().equals(sessionTime1));
    }
    
    @Test
    public void createSessionTest(){
        Sessions sessionTest2 = new Sessions();
        Calendar sessionTime2 = new GregorianCalendar(2016, 10, 22, 11, 45);
        sessionTest2.setSessionsTime(sessionTime2);
        sessionDAO.createSession(sessionTest2);
        Sessions sessionTest3 = sessionDAO.findId(2);
        assertTrue(sessionTest3.getSessionsTime().equals(sessionTime2));
    }
    
    @Test
    public void updateTest(){
        Sessions sessionTest3 = sessionDAO.findId(1);
        Calendar sessionTime3 = sessionTest3.getSessionsTime();
        sessionTime3.set(Calendar.YEAR, 2017);
        sessionTest3.setSessionsTime(sessionTime3);
        sessionDAO.update(sessionTest3);
        sessionTest3 = sessionDAO.findId(1);
        assertTrue(sessionTest3.getSessionsTime().equals(sessionTime3));
    }
    
//    @Test
//    public void deleteTest(){
//        Sessions sessionTest4 = sessionDAO.findId(1);
//        sessionDAO.deleteById(sessionTest4);
//        sessionTest4 = sessionDAO.findId(1);
//        Calendar sessionTime4 = new GregorianCalendar(2016, 10, 22, 11, 45);
//        assertTrue(sessionTest4.getSessionsTime().equals(sessionTime4));
//    }

}
