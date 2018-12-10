package it.unipd.tos.business;

import it.unipd.tos.business.exception.RestaurantBillException;
import org.junit.Test;

import static org.junit.Assert.*;

public class RestaurantClientTest {

    @Test
    public void getOrderPrice() {
        RestaurantClient client = new RestaurantClient();
        try {
            assertEquals(0, client.getOrderPrice(null),0.0);
        } catch (RestaurantBillException e) {
            e.printStackTrace();
        }
    }
}