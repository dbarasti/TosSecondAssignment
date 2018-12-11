package it.unipd.tos.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class MenuItemTest {
    MenuItem pastaCarbonara = new MenuItem(Type.PRIMO, "pasta alla carbonara", 6.70);
    MenuItem pizzaMargherita = new MenuItem(Type.PIZZA, "Pizza Margherita", 4.70);

    @Test
    public void isPizza_MenuItemIsOfTypePizza_returnsTrue(){
        assertEquals(true, pizzaMargherita.isPizza());
    }

    @Test
    public void isPizza_MenuItemIsNotOfTypePizza_returnsFalse(){
        assertEquals(false, pastaCarbonara.isPizza());
    }

    @Test
    public void getItemPrice_CorrectItemIsUsed_returnsPriceOfMenuItem(){
        assertEquals(4.70, pizzaMargherita.getItemPrice(), 0.0);
        assertEquals(6.70, pastaCarbonara.getItemPrice(), 0.0);

    }

}