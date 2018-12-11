////////////////////////////////////////////////////////////////////
// Davide Barasti 1143026
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Dato  un  elenco  di  ordinazioni  (Pizze  e  Primi  piatti)  calcolare  il  totale  (somma  del  prezzo  dei
 * prodotti ordinati);
 * - Se vengono ordinate più di 10 Pizze la meno costosa è in regalo (l’importo totale non considera
 * la pizza meno costosa);
 * - Se  l’importo  totale  delle  ordinazioni  (Pizze  e  Primi)  supera  i  100  euro  viene  fatto  un  5%  di
 * sconto;
 * - Non è possibile avere un’ordinazione con più di 20 elementi (se accade prevedere un messaggio
 * d’errore).
 * */
public class RestaurantClient implements RestaurantBill {
    private static final int DISCOUNT_PERCENTAGE = 5;

    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered) throws RestaurantBillException {
        //case no order item is present in list
        if (itemsOrdered == null) {
            return 0;
        }
        //case order items are too much
        if (itemsOrdered.size() > 20) {
            throw new RestaurantBillException();
        }
        //from now on here client has to pay something for sure
        //let's calculate total to be paid...
        double totalPrice = getTotalPrice(itemsOrdered);

        //if the order contains more than 10 pizzas the cheapest is for free. I'll check if bill is over 100€ later
        int pizzasCount = getCountOfPizzasInOrder(itemsOrdered);
        if(pizzasCount > 10){
            double pizzaPriceToRemoveFromTotal = getCheapestPizzaPriceInOrder(itemsOrdered);
            //removing the cheapest pizza price
            totalPrice -= pizzaPriceToRemoveFromTotal;
        }

        //let's check whether is over 100€ or not
        if (totalPrice > 100){
            totalPrice = getDiscountedPriceOfFivePercent(totalPrice);
        }


        return totalPrice;
    }

    /**
     * @param itemsOrdered list of items in the order.
     * @return cheapest pizza price in order list or 0 if no pizza is present
     */
    private double getCheapestPizzaPriceInOrder(List<MenuItem> itemsOrdered) throws RestaurantBillException {
        Optional<Double> cheapestPizzaPrice = itemsOrdered.stream()
                .filter(MenuItem::isPizza)
                .map(MenuItem::getItemPrice)
                .min(Double::compareTo);
        return cheapestPizzaPrice.orElse(0.0);
    }

    /**
     * @param itemsOrdered list of items in the order
     * @return count of pizzas in the order list or 0 if no pizza is present :(
     */
    private int getCountOfPizzasInOrder(List<MenuItem> itemsOrdered) {

         return  (int) itemsOrdered.stream()
                .filter(MenuItem::isPizza)
                .count();

    }

    /**
     * @param itemsOrdered list of items in the order. Is not null
     * @return total price of order
     */
    private double getTotalPrice(List<MenuItem> itemsOrdered){
        double totalPrice = itemsOrdered.stream()
                .mapToDouble(MenuItem::getItemPrice)
                .sum();
        return totalPrice;
    }

    /**
     * @param originalPrice price of total order before discount
     * @return discounted price using DISCOUNT_PERCENTAGE
     */
    private double getDiscountedPriceOfFivePercent(double originalPrice){
        double discount = (originalPrice*DISCOUNT_PERCENTAGE)/100;
        double discountedPrice = originalPrice - discount;
        return discountedPrice;
    }
}
