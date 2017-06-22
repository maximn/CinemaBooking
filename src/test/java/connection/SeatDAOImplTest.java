package connection;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import domain.Seat;

public class SeatDAOImplTest {
    
    private static SeatDAOImpl seatDAO = new SeatDAOImpl();
    
    @BeforeClass
    public static void beforeTests() {
        Seat seat1 = new Seat();
        seat1.setSeatHall("Yellow");
        seat1.setSeatNum(23);
        seat1.setSeatRow(10);
        seat1.setSeatStatus("reserved");
        
        seatDAO.createSeat(seat1);
    }
    
    @Test
    public void findIdTest(){
        Seat seat2 = seatDAO.findId(1);
        assertTrue(seat2.getSeatHall().equalsIgnoreCase("Brown"));
    }
    
    @Test
    public void listTest(){
        List<Seat> listSeat = seatDAO.list();
        assertTrue(listSeat.get(0).getSeatHall().equalsIgnoreCase("Brown"));
    }
    
    @Test
    public void createSeatTest(){
        Seat seat3 = new Seat();
        seat3.setSeatHall("Red");
        seat3.setSeatNum(23);
        seat3.setSeatRow(10);
        seat3.setSeatStatus("reserved");
        
        seatDAO.createSeat(seat3);
        Seat seat4 = seatDAO.findId(2);
        assertTrue(seat4.getSeatHall().equalsIgnoreCase("Red"));
    }
    
    @Test
    public void updateTest(){
        Seat seat5 = seatDAO.findId(1);
        seat5.setSeatHall("Brown");
        seatDAO.update(seat5);
        Seat seat6 = seatDAO.findId(1);
        assertTrue(seat6.getSeatHall().equalsIgnoreCase("Brown"));
        
    }
    
//    @Test
//    public void deleteSeatTest(){
//        Seat seat3 = new Seat();
//        seat3.setSeatHall("Red");
//        seat3.setSeatNum(23);
//        seat3.setSeatRow(10);
//        seat3.setSeatStatus("reserved");
//        
//        seatDAO.createSeat(seat3);
//        
//        Seat seat7 = seatDAO.findId(2);
//        seatDAO.deleteSeat(seat7);
//        seat7 = seatDAO.findId(2);
//        assertTrue(seat7 == null);
//    }

}
