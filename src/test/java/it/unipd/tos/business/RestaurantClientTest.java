package it.unipd.tos.business;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.Type;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RestaurantClientTest {
    RestaurantClient restaurantClient = new RestaurantClient();
    List<MenuItem> acceptedItemsOrderedAsList = new ArrayList();

    List<MenuItem> moreThanTwentyItemsOrderedAsList = new ArrayList();

    //builds an orderList
    @Before
    public void buildOrdersLists(){
        acceptedItemsOrderedAsList.add(new MenuItem(Type.PIZZA, "Margherita", 4.70));
        acceptedItemsOrderedAsList.add(new MenuItem(Type.PIZZA, "Pomodorini Rucola e Grana", 6.50));
        acceptedItemsOrderedAsList.add(new MenuItem(Type.PRIMO, "Carbonara", 6.00));
        acceptedItemsOrderedAsList.add(new MenuItem(Type.PIZZA, "Capricciosa", 6.80));
        acceptedItemsOrderedAsList.add(new MenuItem(Type.PIZZA, "Speck e Grana", 7.20));
        acceptedItemsOrderedAsList.add(new MenuItem(Type.PRIMO, "Amatriciana", 6.70));
        acceptedItemsOrderedAsList.add(new MenuItem(Type.PIZZA, "Salame Piccante", 6.60));
        acceptedItemsOrderedAsList.add(new MenuItem(Type.PIZZA, "Patatosa", 8.00));
        acceptedItemsOrderedAsList.add(new MenuItem(Type.PRIMO, "Cacio e Pepe", 6.70));

        moreThanTwentyItemsOrderedAsList.add(new MenuItem(Type.PIZZA, "Margherita", 4.70));
        moreThanTwentyItemsOrderedAsList.add(new MenuItem(Type.PIZZA, "Pomodorini Rucola e Grana", 6.50));
        moreThanTwentyItemsOrderedAsList.add(new MenuItem(Type.PRIMO, "Carbonara", 6.00));
        moreThanTwentyItemsOrderedAsList.add(new MenuItem(Type.PIZZA, "Capricciosa", 6.80));
        moreThanTwentyItemsOrderedAsList.add(new MenuItem(Type.PIZZA, "Speck e Grana", 7.20));
        moreThanTwentyItemsOrderedAsList.add(new MenuItem(Type.PRIMO, "Amatriciana", 6.70));
        moreThanTwentyItemsOrderedAsList.add(new MenuItem(Type.PIZZA, "Salame Piccante", 6.60));
        moreThanTwentyItemsOrderedAsList.add(new MenuItem(Type.PIZZA, "Patatosa", 8.00));
        moreThanTwentyItemsOrderedAsList.add(new MenuItem(Type.PRIMO, "Cacio e Pepe", 6.70));
        moreThanTwentyItemsOrderedAsList.add(new MenuItem(Type.PIZZA, "Margherita", 4.70));
        moreThanTwentyItemsOrderedAsList.add(new MenuItem(Type.PIZZA, "Pomodorini Rucola e Grana", 6.50));
        moreThanTwentyItemsOrderedAsList.add(new MenuItem(Type.PRIMO, "Carbonara", 6.00));
        moreThanTwentyItemsOrderedAsList.add(new MenuItem(Type.PIZZA, "Capricciosa", 6.80));
        moreThanTwentyItemsOrderedAsList.add(new MenuItem(Type.PIZZA, "Speck e Grana", 7.20));
        moreThanTwentyItemsOrderedAsList.add(new MenuItem(Type.PRIMO, "Amatriciana", 6.70));
        moreThanTwentyItemsOrderedAsList.add(new MenuItem(Type.PIZZA, "Salame Piccante", 6.60));
        moreThanTwentyItemsOrderedAsList.add(new MenuItem(Type.PIZZA, "Patatosa", 8.00));
        moreThanTwentyItemsOrderedAsList.add(new MenuItem(Type.PRIMO, "Cacio e Pepe", 6.70));
        moreThanTwentyItemsOrderedAsList.add(new MenuItem(Type.PIZZA, "Margherita", 4.70));
        moreThanTwentyItemsOrderedAsList.add(new MenuItem(Type.PIZZA, "Pomodorini Rucola e Grana", 6.50));
        moreThanTwentyItemsOrderedAsList.add(new MenuItem(Type.PRIMO, "Carbonara", 6.00));
        moreThanTwentyItemsOrderedAsList.add(new MenuItem(Type.PIZZA, "Capricciosa", 6.80));
        moreThanTwentyItemsOrderedAsList.add(new MenuItem(Type.PIZZA, "Speck e Grana", 7.20));
        moreThanTwentyItemsOrderedAsList.add(new MenuItem(Type.PRIMO, "Amatriciana", 6.70));
        moreThanTwentyItemsOrderedAsList.add(new MenuItem(Type.PIZZA, "Salame Piccante", 6.60));

    }


    @Test
    public void getOrderPrice_NullFirstParameter_returnsZero() {
        try {
            assertEquals(0, restaurantClient.getOrderPrice(null),0.0);
        } catch (RestaurantBillException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = RestaurantBillException.class)
    public void getOrderPrice_MoreThanTwentyOrderItems_ExceptionThrown() throws RestaurantBillException {

        restaurantClient.getOrderPrice(moreThanTwentyItemsOrderedAsList);

    }

    @Test
    public void getOrderPrice_NoDiscountAppliedOnBill_correctBillSum(){
        double assertionResult = acceptedItemsOrderedAsList.stream()
                .mapToDouble(MenuItem::getItemPrice)
                .sum();
        try {
            assertEquals(assertionResult, restaurantClient.getOrderPrice(acceptedItemsOrderedAsList),0.0);
        } catch (RestaurantBillException e) {
            e.printStackTrace();
        }
    }

}