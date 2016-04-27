package com.mvpdemo.Cart;

import com.mvpdemo.model.Cart;

public interface CartView {
    void showLoading();

    void hideLoading();

    void setCartInfo(Cart cart);

}
