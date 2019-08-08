package com.test.checkout;

import java.util.*;

class Basket {

    private List<Item> items;
    private Map<String,BasketEntry> basketEntries;
    private List<Integer> globalDiscount;

    Basket(){
        items = new ArrayList<>();
        basketEntries = new HashMap<>();
        globalDiscount = new ArrayList<>();
    }
    void add(Item item) {
        CheckUtils.checkNotNull(item);
        items.add(item);
        updateBasketEntry(item);
    }

    void addGlobalDiscount(int discount){
        this.globalDiscount.add(discount);
    }

    void updatePrice(String productCode, double price){
        if(basketEntries.get(productCode)!=null){
            BasketEntry oldEntry = basketEntries.get(productCode);
            BasketEntry updatedEntry = new BasketEntry(oldEntry.getProductCode(),oldEntry.getQuantity(),price);
            basketEntries.put(productCode, updatedEntry);
        }
    }

    public int getQuantity(String productCode) {
        if(basketEntries.get(productCode)!= null){
           return basketEntries.get(productCode).getQuantity();
        }else{
            return 0;
        }

    }
    private void updateBasketEntry(Item item){
        if(basketEntries.get(item.getCode())!=null){
            BasketEntry oldEntry = basketEntries.get(item.getCode());
            BasketEntry updatedEntry = new BasketEntry(oldEntry.getProductCode(),oldEntry.getQuantity()+1,oldEntry.getSoldPrice());
            basketEntries.put(item.getCode(), updatedEntry);
        }else{
            basketEntries.put(item.getCode(),new BasketEntry(item.getCode(),1,item.getPrice()));
        }
    }

    public double checkoutTotal(){
        double total = 0;
        for (BasketEntry entry: basketEntries.values()){
            total = total + entry.getSoldPrice()*entry.getQuantity();
        }
        double totalDiscount = 0;
        for(Integer discount: globalDiscount){
            totalDiscount = totalDiscount + ((discount*total) / 100);
            total = total - totalDiscount;
        }
        return Math.round(total*100)/100.0d;
    }

    public double total(){
        double total = 0;
        for (Item item: items){
            total = total + item.getPrice();
        }
        return total;
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }
}
