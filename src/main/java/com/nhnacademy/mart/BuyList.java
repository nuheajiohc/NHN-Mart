package com.nhnacademy.mart;

import java.util.ArrayList;

public class BuyList {

    private final ArrayList<Item> items = new ArrayList<>();


    // TODO add 메서드 생성
    public void add(String foodInput) {
        String[] splitedFoodInput = foodInput.split(" ");
        for (int i = 0; i < splitedFoodInput.length; i += 2) {
            String name = splitedFoodInput[i];
            int amount = Integer.parseInt(splitedFoodInput[i + 1]);
            items.add(new Item(name, amount));
        }

    }

    public ArrayList<Item> getItemsList() {
        return items;
    }

    public static class Item {
        private final String name;
        private final int amount;

        public Item(String name, int amount) {
            this.name = name;
            this.amount = amount;
        }

        public String getName() {
            return name;
        }

        public int getAmount() {
            return amount;
        }
    }
}
