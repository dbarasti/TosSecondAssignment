////////////////////////////////////////////////////////////////////
// Davide Barasti 1143026
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

public class MenuItem {
    private final Type itemType;
    private String name;
    private Float price;

    public MenuItem(Type itemType, String name, Float price) {
        this.itemType = itemType;
        this.name = name;
        this.price = price;
    }
}
