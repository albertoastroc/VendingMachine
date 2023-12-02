package com.techelevator;

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


        VendingMachine vendingMachine = new VendingMachine(0, "main.csv");
        List<Item> inventory = vendingMachine.loadSnacksFromInventory();



        //First time the menu shows
        int mainMenuOption = 0;
        System.out.println("Main option " + mainMenuOption);
        //1

        //Check the chosen number
        //If the number is NOT 3, repeat, because when it's 3 we want to exit, we don't want it to repeat when 3
        while (mainMenuOption != 3){

            showMainMenu();
            mainMenuOption = input.nextInt();

            //If the option is 1
            if (mainMenuOption == 1) {

                System.out.println();

                //Show the list
                showInventory(inventory);
                System.out.println();

                //Show menu

                //Ask for new option

                //when a option here is chosen/ this could be 1 2 or 3 again
                //goes to line 41

            } else if (mainMenuOption == 2) {

                mainMenuOption = 0;

                showPurchaseMenu();

                int subMenuOption = input.nextInt();


                System.out.println("Sub option " + subMenuOption);

                if (subMenuOption == 3){

                    System.out.println("Finish transaction");
                    continue;

                }

                while (subMenuOption != 3){

                    if (subMenuOption == 1){

                        Character moneyFeedMenu = 'Y';
                        while (moneyFeedMenu.equals('Y')) {
                            System.out.println("Feed money in whole dollars amount: ");
                            int money = input.nextInt();
                            vendingMachine.addMoney(money);

                            System.out.println("Current Money Provided $" + vendingMachine.getBalance());
                            System.out.println("Continue adding money? (Y/N)");
                            moneyFeedMenu = input.next().charAt(0);
                        }

                    } else if (subMenuOption == 2){

                        System.out.println("Select product chosen");
                        subMenuOption = input.nextInt();

                    } else {
                        subMenuOption = 0;
                    }
                    showPurchaseMenu();
                    subMenuOption = input.nextInt();

                }

            }


        }
    }

    public void showInventory(List<Item> inventory){

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