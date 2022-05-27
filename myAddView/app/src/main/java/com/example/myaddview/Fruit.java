package com.example.myaddview;

import java.util.ArrayList;

// Dto 개념
public class Fruit {

    String imageUrl;
    String name;
    String price;
    String count;

    public Fruit(String imageUrl, String name, String price, String count) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.price = price;
        this.count = count;
    }

    // 샘플데이터 생성
    public static ArrayList<Fruit> getFruits() {
        ArrayList<Fruit> list = new ArrayList<>();
        list.add(new Fruit("https://cdn.pixabay.com/photo/2017/06/12/14/53/watermelon-2395804__340.jpg", "수박", "7000", "18"));
        list.add(new Fruit("https://cdn.pixabay.com/photo/2018/08/02/21/51/apples-3580560__340.jpg", "사과", "6000", "18"));
        list.add(new Fruit("https://cdn.pixabay.com/photo/2018/05/26/10/54/strawberries-3431122__340.jpg", "딸기", "8000", "17"));
        list.add(new Fruit("https://cdn.pixabay.com/photo/2017/09/25/12/14/food-2784944__340.jpg", "복숭아", "10000", "45"));
        list.add(new Fruit("https://cdn.pixabay.com/photo/2017/05/02/18/20/blueberries-2278921__340.jpg", "블루베리", "12000", "10"));
        list.add(new Fruit("https://cdn.pixabay.com/photo/2017/03/10/15/15/lime-2133091__340.jpg", "라임", "10000", "33"));
        list.add(new Fruit("https://cdn.pixabay.com/photo/2016/02/23/17/28/mango-1218129__340.png", "망고", "9000", "15"));
        list.add(new Fruit("https://cdn.pixabay.com/photo/2017/02/05/12/31/lemons-2039830__340.jpg", "레몬", "5000", "13"));

        return list;
    }

}
