package connection;



import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import domain.Film;
import domain.Order;

public class OrderDAOImplTest {
    
    private static OrderDAOImpl orderDAO = new OrderDAOImpl();
    private static FilmDAOImpl filmDAO = new FilmDAOImpl();
    
    @Before
    public void beforeTest(){
        Order order1 = new Order();
        orderDAO.createOrder(order1);
        
        Film filmNew = new Film();
        filmNew.setFilmName("Shadow");
        filmNew.setFilmYear((Integer) 1992);
        filmNew.setFilmLength("02:20");
        filmNew.setFilmDescription("Cool film");
        
        
        filmDAO.createFilm(filmNew);
    }
    
    @Test
    public void findIdTest(){
        Order order2 = orderDAO.findId(1);
        assertTrue(order2.getOrderId().equals(1));
    }
    
    @Test
    public void listTest(){
        List<Order> listOrder = orderDAO.list();
        assertTrue(listOrder.get(0).getOrderId().equals(1));
    }
    
    @Test
    public void createOrderTest(){
        Order order2 = new Order();
        orderDAO.createOrder(order2);
        order2 = orderDAO.findId(2);
        assertTrue(order2.getOrderId().equals(2));
    }
    
    @Test
    public void updateTest(){
        Order order3 = orderDAO.findId(1);
        Film film1 = filmDAO.findId(1);
        order3.setFilm(film1);
        orderDAO.update(order3);
        order3 = orderDAO.findId(1);
        assertTrue(order3.getFilm().getFilmId().equals(1));
    }
    
//    @Test
//    public void deleteTest(){
//        Order order3 = orderDAO.findId(1);
//        orderDAO.deleteById(order3);
//        order3 = orderDAO.findId(1);
//        assertTrue(order3 == null);
//    }
    

}
