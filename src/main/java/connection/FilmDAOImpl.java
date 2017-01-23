package connection;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import domain.Film;
import domain.Sessions;

public class FilmDAOImpl extends AbstractDAO implements FilmDAO{

    @Override
    public Film findId(Integer id) throws RuntimeException {
        Film filmCinema = new Film();
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            filmCinema = (Film) session.get(Film.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if((session != null) && (session.isOpen())) 
                session.close();
        }
        return filmCinema;
    }

    @Override
    public List<Film> list() throws RuntimeException {
        Session session = null;
        List<Film> listOfFilms = new ArrayList<>();
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            listOfFilms = session.createCriteria(Film.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
          if((session != null) && (session.isOpen())) session.close(); 
        }
        return listOfFilms;
    }

    @Override
    public void createFilm(Film filmCinema) throws RuntimeException {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.save(filmCinema);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if((session != null) && (session.isOpen())) session.close();
        }
        
    }

    @Override
    public void update(Film filmCinema) throws IllegalArgumentException, RuntimeException {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.update(filmCinema);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if((session != null) && (session.isOpen())) session.close();
        }
        
    }

    @Override
    public void deleteById(Film filmCinema) throws RuntimeException {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.getTransaction();
            session.delete(filmCinema);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if((session != null) && (session.isOpen())) session.close();
        }
        
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
