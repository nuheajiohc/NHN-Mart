package com.nhnacademy.mart;

import java.util.Iterator;

public class Customer {

    // 고객 구매 목록
    private final BuyList buyList;
    private int budget = 20_000;
    private int totalPrice;
    private int balance = budget;

    // 고객 장바구니
    private Basket basket;

    public Customer(BuyList buyList) {
        this.buyList = buyList;
    }

    // 장바구니 챙기기
    public void bring(Basket basket) {
        this.basket = basket;
    }

    // TODO pickFoods 메서드 구현
    public void pickFoods(FoodStand foodStand) {
        Iterator<BuyList.Item> iter = this.buyList.getItemsList().iterator();
        while (iter.hasNext()) {
            BuyList.Item item = iter.next();
            for (int i = 0; i < item.getAmount(); i++) {
                Food validFood = foodStand.checkValidFood(item.getName());
                boolean isValidFood = validFood instanceof Food;
                if (isValidFood) {
                    foodStand.remove(validFood);
                    basket.add(validFood);
                } else {
                    throw new RuntimeException("식품 매대에 없는 상품이거나 재고가 부족합니다.");
                }
            }
        }

    }

    // TODO payTox 메서드 구현
    public void payTox(Counter counter) {
        counter.getCustomerBasket(this.basket);
        counter.pay();
        this.totalPrice = counter.getTotalPrice();
        boolean isValidBudget = this.budget >= this.totalPrice;
        if (isValidBudget) {
            this.balance = this.budget - this.totalPrice;
        } else {
            throw new RuntimeException("구매 금액이 예산을 초과하였습니다.");
        }
    }

    public int getBalance() {
        return this.balance;
    }

    public int getTotalPrice() {
        return this.totalPrice;
    }

}
