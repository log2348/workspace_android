package com.example.recyclerview.models;

import java.io.Serializable;
import java.util.ArrayList;

// Serializable -> 직렬화 (Object -> Byte)
// 역직렬화 (byte -> Object)
public class Food implements Serializable {

    private String thumnbail;
    private String title;
    private String subtitle;
    private String detail;

    // (Alt + insert 생성자 단축기)
    public Food(String thumnbail, String title, String subtitle, String detail) {
        this.thumnbail = thumnbail;
        this.title = title;
        this.subtitle = subtitle;
        this.detail = detail;
    }

    public String getThumnbail() {
        return thumnbail;
    }

    public void setThumnbail(String thumnbail) {
        this.thumnbail = thumnbail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public static ArrayList<Food> getSampleData() {
        ArrayList<Food> foods = new ArrayList<>();
        foods.add(new Food("https://cdn.pixabay.com/photo/2017/02/05/12/31/lemons-2039830__340.jpg", "Food1", "SubTitle1", "detail1"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2017/02/05/12/31/lemons-2039830__340.jpg", "Food2", "SubTitle1", "detail1"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2017/02/05/12/31/lemons-2039830__340.jpg", "Food3", "SubTitle1", "detail1"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2017/02/05/12/31/lemons-2039830__340.jpg", "Food4", "SubTitle1", "detail1"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2017/02/05/12/31/lemons-2039830__340.jpg", "Food5", "SubTitle1", "detail1"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2017/02/05/12/31/lemons-2039830__340.jpg", "Food6", "SubTitle1", "detail1"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2017/02/05/12/31/lemons-2039830__340.jpg", "Food7", "SubTitle1", "detail1"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2017/02/05/12/31/lemons-2039830__340.jpg", "Food8", "SubTitle1", "detail1"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2017/02/05/12/31/lemons-2039830__340.jpg", "Food9", "SubTitle1", "detail1"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2017/02/05/12/31/lemons-2039830__340.jpg", "Food10", "SubTitle1", "detail1"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2017/02/05/12/31/lemons-2039830__340.jpg", "Food11", "SubTitle1", "detail1"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2017/02/05/12/31/lemons-2039830__340.jpg", "Food12", "SubTitle1", "detail1"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2017/02/05/12/31/lemons-2039830__340.jpg", "Food13", "SubTitle1", "detail1"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2017/02/05/12/31/lemons-2039830__340.jpg", "Food14", "SubTitle1", "detail1"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2017/02/05/12/31/lemons-2039830__340.jpg", "Food15", "SubTitle1", "detail1"));

        return foods;
    }
}
