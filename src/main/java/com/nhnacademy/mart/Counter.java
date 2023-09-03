package com.nhnacademy.mart;

import java.util.Iterator;

public class Counter {
    private Basket basket;
    private int totalPrice = 0;

    // TODO pay 메서드 구현 (카운터에서 계산 처리 메서드)

    public void getCustomerBasket(Basket basket) {
        this.basket = basket;
    }

    public void pay() {
        Iterator<Food> iter = basket.getFoodsList().iterator();
        while (iter.hasNext()) {
            int price = iter.next().getPrice();
            this.totalPrice += price;
        }
    }

    public int getTotalPrice() {
        return this.totalPrice;
    }
}
