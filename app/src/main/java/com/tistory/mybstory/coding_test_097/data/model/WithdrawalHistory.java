package com.tistory.mybstory.coding_test_097.data.model;

public class WithdrawalHistory {

    private String title;
    private int price;
    private int salePrice;

    public WithdrawalHistory(String title, int price, int salePrice) {
        this.title = title;
        this.price = price;
        this.salePrice = salePrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof WithdrawalHistory)) {
            return false;
        }

        WithdrawalHistory history = (WithdrawalHistory) obj;

        return this.title.equals(history.title) &&
                this.price == history.price &&
                this.salePrice == history.salePrice;
    }

    public boolean getSign() {
        return price * 0.9 >= salePrice;
    }
}
