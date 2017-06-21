package connection;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.Film;
import domain.Sessions;

public class FilmDAOImplTest {

    private static FilmDAOImpl filmDAO = new FilmDAOImpl();

    @BeforeClass
    public static void beforeTests() {

        Sessions sessions1 = new Sessions();
        Calendar sessionTime1 = new GregorianCalendar(2015, 10, 22, 11, 45);
        sessions1.setSessionsTime(sessionTime1);

        Set<Sessions> sessionsSet = new HashSet<Sessions>();
        sessionsSet.add(sessions1);

        Film filmNew = new Film();
        filmNew.setFilmName("Shadow");
        filmNew.setFilmYear((Integer) 1992);
        filmNew.setFilmLength("02:20");
        filmNew.setFilmDescription("Cool film");
        filmNew.setSessionsSet(sessionsSet);
        
        filmDAO.createFilm(filmNew);
    }
    
    @Test
    public void findIdTest(){
        Film film1 = filmDAO.findId(1);
        assertTrue(film1.getFilmName().equalsIgnoreCase("Shadow"));
    }
    
    @Test
    public void listTest(){
        List<Film> list = filmDAO.list();
        Film film = list.get(0);
        assertTrue(film.getFilmName().equalsIgnoreCase("SShadow"));
    }
    
    @Test
    public void createFilmTest(){
        Film filmNew = new Film();
        filmNew.setFilmName("Panda");
        filmNew.setFilmYear((Integer) 2006);
        filmNew.setFilmLength("02:20");
        filmNew.setFilmDescription("Cool film");
        //filmNew.setSessionsSet(sessionsSet);
        
        filmDAO.createFilm(filmNew);
        Film filmNew1 = filmDAO.findId(2);
        assertTrue(filmNew1.getFilmName().equalsIgnoreCase("Panda"));
        
    }
    
    @Test
    public void updateFilmTest(){
        Film filmNew1 = filmDAO.findId(1);
        filmNew1.setFilmName("SShadow");
        filmDAO.update(filmNew1);
        filmNew1 = filmDAO.findId(1);
        assertTrue(filmNew1.getFilmName().equalsIgnoreCase("SShadow"));
        
    }
    
//    @Test
//    public void deleteFilmTest(){
//        Film filmNew1 = filmDAO.findId(1);
//        filmDAO.deleteFilm(filmNew1);
//        List<Film> list = filmDAO.list();
////        Film filmNew2 = filmDAO.findId(1);
////        Film filmNew3 = filmDAO.findId(2);
////        Integer filmId = filmNew3.getFilmId();
//        Film filmNew4 = filmDAO.findId(0);
//        Integer listLength = list.size();
//        assertTrue(listLength.equals((int) 1));
//    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

}
