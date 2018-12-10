////////////////////////////////////////////////////////////////////
// Davide Barasti 1143026
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

import java.util.Comparator;

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

    /**
     * Tells whether menuItem is a pizza
     * @return true is pizza
     */
    public boolean isPizza(){
        return itemType == Type.PIZZA;
    }
}
