package com.test.checkout;

import java.util.ArrayList;
import java.util.List;

public class PromotionalRules {

    List<PromotionalRule> rules;

    public PromotionalRules(){
        this.rules = new ArrayList<>();
    }
    public void add(PromotionalRule promotionalRule) {
        rules.add(promotionalRule);
    }

    public List<PromotionalRule> getRules() {
        return new ArrayList<>(rules);
    }
}
