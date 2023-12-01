package com.techelevator;

public abstract class Item {

    private final String name;
    private final int quantity;
    private final double price;
    private final String slot;
    private final String category;

    public Item(String name, int quantity, double price, String slot, String category) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.slot = slot;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", slot='" + slot + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    public String getName() {
        return name;
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
