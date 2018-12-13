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

    public static final int DISCOUNT_PERCENTAGE = 5;
    RestaurantClient restaurantClient = new RestaurantClient();

    List<MenuItem> acceptedItemsOrderedAsList = new ArrayList();
    List<MenuItem> moreThanTwentyItemsOrderedAsList = new ArrayList();
    List<MenuItem> moreThanHundredEurosLessThanTenPizzasOrderAsList = new ArrayList<>();
    List<MenuItem> moreThanHundredEurosMoreThanTenPizzasOrderAsList = new ArrayList<>();


    /**
     * fill the lists according to their names
     */
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

        moreThanHundredEurosLessThanTenPizzasOrderAsList.add(new MenuItem(Type.PIZZA, "Salame Piccante", 10.60));
        moreThanHundredEurosLessThanTenPizzasOrderAsList.add(new MenuItem(Type.PIZZA, "Salame Piccante", 8.60));
        moreThanHundredEurosLessThanTenPizzasOrderAsList.add(new MenuItem(Type.PIZZA, "Salame Piccante", 4.60));
        moreThanHundredEurosLessThanTenPizzasOrderAsList.add(new MenuItem(Type.PIZZA, "Salame Piccante", 7.60));
        moreThanHundredEurosLessThanTenPizzasOrderAsList.add(new MenuItem(Type.PIZZA, "Salame Piccante", 8.50));
        moreThanHundredEurosLessThanTenPizzasOrderAsList.add(new MenuItem(Type.PIZZA, "Salame Piccante", 9.20));
        moreThanHundredEurosLessThanTenPizzasOrderAsList.add(new MenuItem(Type.PIZZA, "Salame Piccante", 7.00));
        moreThanHundredEurosLessThanTenPizzasOrderAsList.add(new MenuItem(Type.PIZZA, "Salame Piccante", 7.60));
        moreThanHundredEurosLessThanTenPizzasOrderAsList.add(new MenuItem(Type.PRIMO, "Amatriciana", 8.60));
        moreThanHundredEurosLessThanTenPizzasOrderAsList.add(new MenuItem(Type.PRIMO, "Cacio e Pepe abbondante", 9.50));
        moreThanHundredEurosLessThanTenPizzasOrderAsList.add(new MenuItem(Type.PRIMO, "Amatriciana", 8.60));
        moreThanHundredEurosLessThanTenPizzasOrderAsList.add(new MenuItem(Type.PRIMO, "Carbonara abbondante", 9.60));
        moreThanHundredEurosLessThanTenPizzasOrderAsList.add(new MenuItem(Type.PRIMO, "Amatriciana", 8.60));

        moreThanHundredEurosMoreThanTenPizzasOrderAsList.add(new MenuItem(Type.PIZZA, "Salame Piccante", 10.60));
        moreThanHundredEurosMoreThanTenPizzasOrderAsList.add(new MenuItem(Type.PIZZA, "Salame Piccante", 8.60));
        moreThanHundredEurosMoreThanTenPizzasOrderAsList.add(new MenuItem(Type.PIZZA, "Margherita", 4.60));
        moreThanHundredEurosMoreThanTenPizzasOrderAsList.add(new MenuItem(Type.PIZZA, "Salame Piccante", 7.60));
        moreThanHundredEurosMoreThanTenPizzasOrderAsList.add(new MenuItem(Type.PIZZA, "Salame Piccante", 8.50));
        moreThanHundredEurosMoreThanTenPizzasOrderAsList.add(new MenuItem(Type.PIZZA, "Salame Piccante", 9.20));
        moreThanHundredEurosMoreThanTenPizzasOrderAsList.add(new MenuItem(Type.PIZZA, "Salame Piccante", 7.00));
        moreThanHundredEurosMoreThanTenPizzasOrderAsList.add(new MenuItem(Type.PIZZA, "Salame Piccante", 7.60));
        moreThanHundredEurosMoreThanTenPizzasOrderAsList.add(new MenuItem(Type.PIZZA, "Salame Piccante", 9.20));
        moreThanHundredEurosMoreThanTenPizzasOrderAsList.add(new MenuItem(Type.PIZZA, "Salame Piccante", 7.00));
        moreThanHundredEurosMoreThanTenPizzasOrderAsList.add(new MenuItem(Type.PIZZA, "Salame Piccante", 7.60));
        moreThanHundredEurosMoreThanTenPizzasOrderAsList.add(new MenuItem(Type.PRIMO, "Amatriciana", 8.60));
        moreThanHundredEurosMoreThanTenPizzasOrderAsList.add(new MenuItem(Type.PRIMO, "Cacio e Pepe abbondante", 9.50));
        moreThanHundredEurosMoreThanTenPizzasOrderAsList.add(new MenuItem(Type.PRIMO, "Amatriciana", 8.60));
        moreThanHundredEurosMoreThanTenPizzasOrderAsList.add(new MenuItem(Type.PRIMO, "Carbonara abbondante", 9.60));
        moreThanHundredEurosMoreThanTenPizzasOrderAsList.add(new MenuItem(Type.PRIMO, "Amatriciana", 8.60));

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

    @Test
    public void getOrderPrice_MoreThanHundredEurosLessThanTenPizzas_correctBillSumWithDiscount(){
        double assertionResult = 108.60 - ((108.60*DISCOUNT_PERCENTAGE)/100);
        try {
            assertEquals(assertionResult, restaurantClient.getOrderPrice(moreThanHundredEurosLessThanTenPizzasOrderAsList),0.0);
        } catch (RestaurantBillException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getOrderPrice_MoreThanHundredEurosMoreThanTenPizzas_correctBillSumWithDiscountAndFreeCheapestPizza(){
        double initialBill = 132.40;
        double cheapestPizzaPrice = 4.60;
        double billWithoutCheapestPizza = initialBill - cheapestPizzaPrice;
        double assertionResult = billWithoutCheapestPizza - ((billWithoutCheapestPizza*DISCOUNT_PERCENTAGE)/100);
        try {
            assertEquals(assertionResult, restaurantClient.getOrderPrice(moreThanHundredEurosMoreThanTenPizzasOrderAsList),0.0);
        } catch (RestaurantBillException e) {
            e.printStackTrace();
        }
    }

}