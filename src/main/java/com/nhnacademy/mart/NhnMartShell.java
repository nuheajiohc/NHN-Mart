package com.nhnacademy.mart;

import java.util.Scanner;

public class NhnMartShell {

    public static void main(String[] args) {

        NhnMart mart = new NhnMart();
        printWelcomeMessage();
        mart.prepareMart();

        BuyList buyList = inputBuyListFromShell();

        // TODO 본인이름 영어로 변수명 작성!
        // 본인이름을 각자 맞게 영어로 변경
        // 홍길동 학생
        // -> hongGilDong or gilDong
        Customer choiJaeHun = new Customer(buyList);

        // 장바구니를 챙긴다.
        choiJaeHun.bring(mart.provideBasket());

        // 식품을 담는다.
        choiJaeHun.pickFoods(mart.getFoodStand());

        // 카운터에서 계산한다.
        choiJaeHun.payTox(mart.getCounter());

        printTotalPrice(choiJaeHun.getTotalPrice());
        printCustomerBalance(choiJaeHun.getBalance());
    }

    private static BuyList inputBuyListFromShell() {
        // TODO Scanner 입력을 받아 buyList 만들기
        Scanner input = new Scanner(System.in);
        String foodInput = input.nextLine();

        BuyList buyList = new BuyList();

        buyList.add(foodInput);
        return buyList;
    }

    private static void printWelcomeMessage() {
        System.out.println("NHN 마트에 오신 것을 환영합니다. 사고 싶은 물건을 골라주세요.\n");
    }

    private static void printTotalPrice(int totalPrice) {
        System.out.println("총 가격은 " + totalPrice + "원 입니다.");
    }

    private static void printCustomerBalance(int balance) {
        System.out.println("고객님 결제 후 잔액 : " + balance);
    }
}
