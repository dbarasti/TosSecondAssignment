////////////////////////////////////////////////////////////////////
// Davide Barasti 1143026
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

public class MenuItem {
    private final Type itemType;
    private String name;
    private double price;

    public MenuItem(Type itemType, String name, double price) {
        this.itemType = itemType;
        this.name = name;
        this.price = price;
    }

    public double getItemPrice(){
        return price;
    }
}
