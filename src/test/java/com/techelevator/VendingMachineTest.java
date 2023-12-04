package com.techelevator;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class VendingMachineTest {
    private VendingMachine vendingMachine;

    @Before
    public void setup()  {
        this.vendingMachine = new VendingMachine(0.0, "main.cvs");
    }


    @Test
    public void adding_money_to_balance() {

       double expectedResult = 10.0;

       vendingMachine.addMoney(10.0);

       assertEquals("Expected results is: ", expectedResult, vendingMachine.getBalance(), 0);

    }




}
