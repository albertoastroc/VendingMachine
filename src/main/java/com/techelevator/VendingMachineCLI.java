package com.techelevator;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/*
 * This class is provided to you as a *suggested* class to start
 * your project. Feel free to refactor this code as you see fit.
 */
public class VendingMachineCLI {

    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        VendingMachineCLI cli = new VendingMachineCLI();


        cli.run();
    }



    public void run() {

        moneyToChange(8.5);


        VendingMachine vendingMachine = new VendingMachine(0, "main.csv");
        List<Item> inventory = vendingMachine.loadSnacksFromInventory();


        //First time the menu shows
        int mainMenuOption = 0;
        System.out.println("Main option " + mainMenuOption);
        //1

        //Check the chosen number
        //If the number is NOT 3, repeat, because when it's 3 we want to exit, we don't want it to repeat when 3
        while (mainMenuOption != 3) {

            showMainMenu();
            mainMenuOption = input.nextInt();

            //If the option is 1
            if (mainMenuOption == 1) {

                System.out.println();
                showInventory(inventory);
                System.out.println();


            } else if (mainMenuOption == 2) {

                mainMenuOption = 0;

                showPurchaseMenu();

                int subMenuOption = input.nextInt();


                System.out.println("Sub option " + subMenuOption);

                while (subMenuOption != 3) {

                    if (subMenuOption == 1) {

                        //NEED TO MAKE SURE ONLY NUMBERS NO LETTERS
                        //TELL THE USER ONLY Y OR N WILL WORK
                        //CHECK FOR CASE

                        String moneyFeedMenu = "y";
                        while (moneyFeedMenu.equals("y")) {
                            System.out.println("Feed money in whole dollars amount: ");
                            int money = input.nextInt();
                            vendingMachine.addMoney(money);

                            System.out.println("Current Money Provided $" + vendingMachine.getBalance());
                            System.out.println("Continue adding money? (y/n)");
                            moneyFeedMenu = String.valueOf(input.next().charAt(0)).toLowerCase();

//                            while (!moneyFeedMenu.equals("y") ||  !moneyFeedMenu.equals("n")){
//                                System.out.println("Invalid input");
//                                System.out.println("Continue adding money? (Y/N)");
//                                moneyFeedMenu = String.valueOf(input.next().charAt(0)).toLowerCase();
//                            }
                        }


                    } else if (subMenuOption == 2) {

                        showInventory(inventory);
                        System.out.println("Choose an item");
                        //Show items
                        //User chooses items until they press 3
                        //When the user presses 3 return to main menu
                        String itemChoice = input.next();

                        //ACCOUNT FOR LOWER CASE LETTERS IN SLOT

                        if (vendingMachine.getMap().containsKey(itemChoice)){

                            int chosenItemIndex = vendingMachine.getMap().get(itemChoice);
                            Item chosenItem = inventory.get(chosenItemIndex);
                            vendingMachine.subtractMoney(chosenItem.getPrice());
                            chosenItem.dispenseMessage();
                            chosenItem.removeOneFromQuantity();
                            System.out.println("Current Balance is " + vendingMachine.getBalance());

                        }

                    }


                    showPurchaseMenu();

                    subMenuOption = input.nextInt();


                }


                vendingMachine.subtractMoney(vendingMachine.getBalance());
                System.out.println(vendingMachine.getBalance());



            }




        }
    }


    public void moneyToChange(double moneyDouble){

        double test = 5.35 * 100;


        int dollars = (int)test/100;
        double dollarRemainder = test%100;
        int quarters = (int)dollarRemainder/25;
        double quarterRemainder = dollarRemainder%25;
        int dimes = (int)quarterRemainder/10;
        double dimesRemainder = quarterRemainder%10;
        int nickles = (int)dimesRemainder/5;

        System.out.println("Printing dollars " + dollars);
        System.out.println("Printing quarters " + quarters);
        System.out.println("Printing dimes " + dimes);
        System.out.println("Printing nickles " + nickles);






//        double hundreds = (test - test);
//        double quarters = (hundreds * 100) / 25;
//
//        System.out.println(quarters);

    }


    public void showInventory(List<Item> inventory) {

        for (int i = 0; i < inventory.size(); i++) {

            if (inventory.get(i).getQuantity() != 0) {

                System.out.println(inventory.get(i));
            }
        }

    }


    public void showMainMenu() {

        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");
        System.out.print("Enter 1 2 or 3 ");
        System.out.println();

    }

    public void showPurchaseMenu() {

        System.out.println("(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");
        System.out.print("Enter 1 2 or 3 ");
        System.out.println();

    }


    //  menu function

    //  create and write log function

}