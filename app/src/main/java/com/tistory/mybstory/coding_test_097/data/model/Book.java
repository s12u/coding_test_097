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
    @SerializedName("thumbnail")
    private String thumbUrl;
    @SerializedName("authors")
    private String[] authors;
    @SerializedName("translators")
    private String[] translators;
    @SerializedName("publisher")
    private String publisher;

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

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String[] getTranslators() {
        return translators;
    }

    public void setTranslators(String[] translators) {
        this.translators = translators;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getTransactionAmount() {
        return this.price * 0.9 > this.salePrice ?
                Math.abs(this.salePrice) * -1 : this.salePrice;
    }
}
