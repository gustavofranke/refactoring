package demo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp(){
        customer = new Customer("Gustavo");
    }

    @Test
    public void test2Movies() {
        Movie milesAhead = new Movie("Miles ahead", 1);
        Movie bornToBeBlue = new Movie("Born to be Blue", 2);

        Rental milesAheadRental =new Rental(milesAhead, 3);
        Rental bornToBeBlueRental =new Rental(bornToBeBlue, 3);

        customer.addRental(milesAheadRental);
        customer.addRental(bornToBeBlueRental);

        assertEquals(customer.statement(), "Rental Record for Gustavo\n" +
                "\tMiles ahead\t9.0\n" +
                "\tBorn to be Blue\t1.5\n" +
                "Amount owed is 10.5\n" +
                "You earned 3 frequent renter points");
    }

    public void test3Movies() {
        Movie lockStock = new Movie("Lock, Stock and Two Smoking Barrels", 1);
        Movie fightClub = new Movie("Fight Club", 0);
        Movie withnail = new Movie("Withnail and I", 2);

        Rental lockStockRental =new Rental(lockStock, 2);
        Rental fightClubRental =new Rental(fightClub, 5);
        Rental withnailRental =new Rental(withnail, 7);

        customer.addRental(lockStockRental);
        customer.addRental(fightClubRental);
        customer.addRental(withnailRental);

        assertEquals(customer.statement(), "Rental Record for Gustavo\n" +
                "\tLock, Stock and Two Smoking Barrels\t6.0\n" +
                "\tFight Club\t6.5\n" +
                "\tWithnail and I\t7.5\n" +
                "Amount owed is 20.0\n" +
                "You earned 4 frequent renter points");
    }
}
