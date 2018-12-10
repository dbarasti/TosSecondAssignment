////////////////////////////////////////////////////////////////////
// Davide Barasti 1143026
////////////////////////////////////////////////////////////////////
package it.unipd.tos;

import it.unipd.tos.business.RestaurantClient;
import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple RestaurantBill.
 */
public class RestaurantBillTest{

    public void getOrderPrice_nullParameter_return0(){
        RestaurantClient client = new RestaurantClient();
        try {
            assertEquals(0,client.getOrderPrice(null));
        } catch (RestaurantBillException e) {
            e.printStackTrace();
        }
    }
}
