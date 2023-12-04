package com.techelevator;

public abstract class Item {

    private final String name;
    private int quantity;
    private final double price;
    private final String slot;
    private final String category;

    public Item(String slot, String name, double price, String category, int quantity) {
        this.name = name;
        this.quantity = 5;
        this.price = price;
        this.slot = slot;
        this.category = category;
    }

    @Override
    public String toString() {
        String stock = "In stock";
        System.out.printf("%-10s %-20s $%-10.2f %-15s %-25s", slot, name, price, stock, quantity);



        return "";
//                slot + " " + name + "$" + price + stock + quantity;
    }

    public String getName() {
        return name;
    }

    public void removeOneFromQuantity(){

        if (quantity != 0){
            quantity -= 1;
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getSlot() {
        return slot;
    }

    public String getCategory() {
        return category;
    }

    public abstract void dispenseMessage();

}
