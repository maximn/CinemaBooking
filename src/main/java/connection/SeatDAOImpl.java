package connection;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import domain.Film;
import domain.Seat;

public class SeatDAOImpl extends AbstractDAO implements SeatDAO {

    @Override
    public Seat findId(Integer id) throws RuntimeException {
        Seat seatCinema = new Seat();
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            seatCinema = (Seat) session.get(Seat.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if((session != null) && (session.isOpen())) 
                session.close();
        }
        return seatCinema;
    }

    @Override
    public List<Seat> list() throws RuntimeException {
        Session session = null;
        List<Seat> listOfSeats = new ArrayList<>();
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            listOfSeats = session.createCriteria(Seat.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
          if((session != null) && (session.isOpen())) session.close(); 
        }
        return listOfSeats;
    }

    @Override
    public void createSeat(Seat seatInConcreteHall) throws RuntimeException {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.save(seatInConcreteHall);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if((session != null) && (session.isOpen())) session.close();
        }
        
    }

    @Override
    public void update(Seat seatInConcreteHall) throws IllegalArgumentException, RuntimeException {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.update(seatInConcreteHall);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if((session != null) && (session.isOpen())) session.close();
        }
        
    }

    @Override
    public void deleteSession(Seat seatInConcreteHall) throws RuntimeException {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.getTransaction();
            session.delete(seatInConcreteHall);
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
