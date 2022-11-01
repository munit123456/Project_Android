package com.example.bt10_sqlite.model;

public class Category {

    private int id;

    private String ten_Category;

    public Category(String ten_Category) {
        this.ten_Category = ten_Category;
    }

    public Category(int id, String ten_Category) {
        this.id = id;
        this.ten_Category = ten_Category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen_Category() {
        return ten_Category;
    }

    public void setTen_Category(String ten_Category) {
        this.ten_Category = ten_Category;
    }
}
