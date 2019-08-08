package com.test.checkout;

public enum PromotionalRule implements Rule{

    TOTAL_OVER_60{
        @Override
        public void apply(Basket basket) {
            if(basket.total()>60) {
                basket.addGlobalDiscount(10);
            }
        }
    },
    TRAVELCARD_HOLDER{
        @Override
        public void apply(Basket basket) {
            Item travelCardWithNewPrice = new Item("001","Travel Card Holder",8.50d);
            if(basket.getQuantity(travelCardWithNewPrice.getCode())>=2){
                basket.updatePrice(travelCardWithNewPrice.getCode(),travelCardWithNewPrice.getPrice());
            }

        }
    };
}
