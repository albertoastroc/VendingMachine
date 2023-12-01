package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.ArrayList;
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

        showMenu();

        String mainMenuOption = input.nextLine().trim();


        if (mainMenuOption.equals("1")) {

            showInventory(inventory);

            System.out.println();

        } else if (mainMenuOption.equals("2")) {
            System.out.println("Option entered was 2");
        } else if (mainMenuOption.equals("3")) {


            System.out.println("Option entered was 3");
        }

        showMenu();


    }

    public void showInventory(List<Item> inventory){

        for (int i = 0; i < inventory.size(); i++) {

            if (inventory.get(i).getQuantity() != 0) {

                System.out.println(inventory.get(i));
            }
        }

    }


    public void showMenu() {

        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");
        System.out.print("Enter 1 2 or 3 ");
        System.out.println();

    }


    //  menu function

    //  create and write log function

}