////////////////////////////////////////////////////////////////////
// Davide Barasti 1143026
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;

import java.util.List;

public class RestaurantClient implements RestaurantBill {
    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered) throws RestaurantBillException {
        //case no order item is present in list
        if (itemsOrdered == null)
            return 0;

        //case order items are too much
        if (itemsOrdered.size() > 20)
            throw new RestaurantBillException();

        //case client gets a discount

        return 0;
    }
}
