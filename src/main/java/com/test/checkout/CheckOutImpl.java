package com.test.checkout;

public class CheckOutImpl implements CheckOut {

    PromotionalRules promotionalRules;
    private Basket basket;

    public CheckOutImpl(PromotionalRules promotionalRules){
        this.promotionalRules = promotionalRules;
        this.basket = new Basket();
    }
    @Override
    public void scan(Item item) {
        basket.add(item);
    }

    @Override
    public Double total() {

        for(PromotionalRule promotionalRule: promotionalRules.getRules()){
            promotionalRule.apply(basket);
        }
        return basket.checkoutTotal();
    }
}
