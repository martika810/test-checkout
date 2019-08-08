package com.test.checkout;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class CheckoutImplTest {

    Item product001 = new Item("001", "Travel Card Holder", 9.25d);
    Item product002 = new Item("002", "Personalised cufflinks", 45.00d);
    Item product003 = new Item("003", "Kids T-shirt", 19.95d);
    PromotionalRules promotionalRules;

    @Before
    public void setup(){
        promotionalRules = new PromotionalRules();
        promotionalRules.add(PromotionalRule.TOTAL_OVER_60);
        promotionalRules.add(PromotionalRule.TRAVELCARD_HOLDER);
    }



    @Test
    public void checkout_ifTotalOver60() {
        CheckOut checkout = new CheckOutImpl(promotionalRules);
        checkout.scan(product001);
        checkout.scan(product002);
        checkout.scan(product003);

        assertEquals(new Double(66.78), checkout.total());
    }

    @Test
    public void checkout_if2TravelCards() {
        CheckOut checkout = new CheckOutImpl(promotionalRules);
        checkout.scan(product001);
        checkout.scan(product003);
        checkout.scan(product001);

        assertEquals(new Double(36.95), checkout.total());
    }


    @Test
    public void checkout_ifAllRulesApply() {
        CheckOut checkout = new CheckOutImpl(promotionalRules);
        checkout.scan(product001);
        checkout.scan(product002);
        checkout.scan(product001);
        checkout.scan(product003);

        assertEquals(new Double(73.76), checkout.total());
    }

    @Test
    public void checkout_emptyBasket() {
        CheckOut checkout = new CheckOutImpl(promotionalRules);
        assertEquals(new Double(0), checkout.total());
    }

    @Test
    public void checkout_ifNoRulesApply() {
        CheckOut checkout = new CheckOutImpl(promotionalRules);
        checkout.scan(product001);
        assertEquals(new Double(9.25), checkout.total());
    }

    @Test
    public void checkout_ifEmptyRules() {
        CheckOut checkout = new CheckOutImpl(new PromotionalRules());
        checkout.scan(product001);
        assertEquals(new Double(9.25), checkout.total());
    }

    @Test
    public void checkout_ifEmptyRules_emptyBasket() {
        CheckOut checkout = new CheckOutImpl(new PromotionalRules());
        assertEquals(new Double(0), checkout.total());
    }
}
