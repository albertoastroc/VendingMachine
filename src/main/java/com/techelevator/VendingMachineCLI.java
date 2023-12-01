package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * This class is provided to you as a *suggested* class to start
 * your project. Feel free to refactor this code as you see fit.
 */
public class VendingMachineCLI {
static double balance = 0;



	public static void main(String[] args) {
		VendingMachineCLI cli = new VendingMachineCLI();
		cli.run();
	}

	public void run() {
		List<Item> tempTestList = loadSnacksFromInventory("main.csv");
		System.out.println(tempTestList);

	}

	public static List<Item> loadSnacksFromInventory(String filename) {
		List<Item> result = new ArrayList<>();
		File input = new File(filename);

		if (input.exists() && input.isFile()) {
			try (Scanner inputScanner = new Scanner(input)) {
				while (inputScanner.hasNextLine()) {
					String currentLine = inputScanner.nextLine();

					String[] splitValues = currentLine.split(",");

					String slot = splitValues[0];
					String name = splitValues[1];
					String price = splitValues[2];
					double priceDouble = Double.parseDouble(price);
					String category = splitValues[3];
					int quantity = 5;

					Item current;

					if (category.equals("Gum")) {
						current = new Gum(slot, name, priceDouble, category, quantity);

					} else if (category.equals("Drink")) {
						current = new Drink(slot, name, priceDouble, category, quantity);

					} else if (category.equals("Candy")) {
						current = new Candy(slot, name, priceDouble, category, quantity);

					} else {
						current = new Munchy(slot, name, priceDouble, category, quantity);
					}
					result.add(current);

				}

			} catch(FileNotFoundException e){
					System.out.println("Something went wrong");
				}

			}
			return result;
	}

	public static void toAddMoney(double insertedMoney) {
		balance = balance + insertedMoney;
	}

	public static void toSubtractMoney(double itemPrice) {
		balance -= itemPrice;
	}

	
	//  menu function

	//  create and write log function

}