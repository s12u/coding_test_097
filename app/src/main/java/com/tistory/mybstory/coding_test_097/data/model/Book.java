package com.tistory.mybstory.coding_test_097.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * A Data class for Book entity.
 */
public class Book {

    @SerializedName("title")
    private String title;
    @SerializedName("contents")
    private String contents;
    @SerializedName("price")
    private int price;
    @SerializedName("sale_price")
    private int salePrice;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }
}
