package com.mvpdemo.model;


public class LineItem {
    public String name;
    public String currencyCode;
    public String imgUrl;
    public long priceInMicros, quantity;

    public LineItem(String name, String currencyCode, String imgUrl, long priceInMicros, long quantity) {
        this.name = name;
        this.currencyCode = currencyCode;
        this.imgUrl = imgUrl;
        this.priceInMicros = priceInMicros;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public long getPriceInMicros() {
        return priceInMicros;
    }

    public void setPriceInMicros(long priceInMicros) {
        this.priceInMicros = priceInMicros;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
