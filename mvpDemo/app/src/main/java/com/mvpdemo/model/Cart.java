package com.mvpdemo.model;

import java.util.List;

public class Cart {
    public String buyer, creditCard;
    public List<LineItem> lineItems;

    public Cart(String buyer, String creditCard, List<LineItem> lineItems) {
        this.buyer = buyer;
        this.creditCard = creditCard;
        this.lineItems = lineItems;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }


    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }
}
