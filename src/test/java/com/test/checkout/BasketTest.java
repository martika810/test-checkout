package com.test.checkout;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BasketTest {

    private Basket basket;
    private Item item1;
    @Before
    public void setup(){
        basket = new Basket();
        item1 = new Item("004","Test Item 1", 2.00);
    }
    @Test
    public void addItem() {
       basket.add(item1);
        Assert.assertEquals(1,basket.getQuantity("004"));
        basket.add(item1);
        Assert.assertEquals(2,basket.getQuantity("004"));
    }

    @Test
    public void total(){

        basket.add(item1);
        basket.add(item1);
        Assert.assertEquals(4.00,basket.total(),0);
    }

    @Test
    public void updatePrice(){
        basket.add(item1);
        basket.add(item1);
        basket.updatePrice(item1.getCode(),1.00);
        Assert.assertEquals(2.00, basket.checkoutTotal(),0);
    }


    @Test(expected = IllegalArgumentException.class)
    public void total_ifNullItem(){
        basket.add(null);
        basket.total();
    }


}
