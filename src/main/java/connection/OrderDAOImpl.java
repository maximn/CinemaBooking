package connection;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import domain.Film;
import domain.Order;
import domain.Sessions;

public class OrderDAOImpl extends AbstractDAO implements OrderDAO {

    @Override
    public Order findId(Integer id) throws RuntimeException {
        Order ordersCinema = new Order();
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            ordersCinema = (Order) session.get(Order.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if((session != null) && (session.isOpen())) 
                session.close();
        }
        return ordersCinema;
    }

    @Override
    public List<Order> findOrdersFilm(Film film) throws RuntimeException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Order> list() throws RuntimeException {
        Session session = null;
        List<Order> listOfOrders = new ArrayList<Order>();
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            listOfOrders = session.createCriteria(Order.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
          if((session != null) && (session.isOpen())) session.close(); 
        }
        return listOfOrders;
    }

    @Override
    public void createOrder(Order orderCinema) throws RuntimeException {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.save(orderCinema);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void update(Order orderCinema) throws IllegalArgumentException, RuntimeException {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.update(orderCinema);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if((session != null) && (session.isOpen())) session.close();
        }
        
    }

    @Override
    public void deleteById(Order orderCinema) throws RuntimeException {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.getTransaction();
            session.delete(orderCinema);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if((session != null) && (session.isOpen())) session.close();
        }
        
    }

}
