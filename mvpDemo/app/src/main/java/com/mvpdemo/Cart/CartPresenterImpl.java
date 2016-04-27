package com.mvpdemo.Cart;


import com.mvpdemo.model.Cart;

public class CartPresenterImpl implements CartPresenter, CartInterector.OnCartLoaded {
    private CartView cartView;
    private CartInterector cartInterector;

    public CartPresenterImpl(CartView cartView) {
        this.cartView = cartView;
        this.cartInterector = new CartInterectorImpl();
    }


    @Override
    public void fetchCartDetails() {
        cartView.showLoading();
        cartInterector.getCardRest(this, 0, 0);
    }

    @Override
    public void onSuccess(Cart cart, int requestCode, int responseCode) {
        cartView.hideLoading();
        cartView.setCartInfo(cart);
    }

    @Override
    public void onSuccess(String response, int requestCode, int responseCode) {
//        This will never called
    }

    @Override
    public void onError(String response, int requestCode, int responseCode) {
        cartView.hideLoading();

    }

    @Override
    public void onDestroy() {
        cartView = null;
        cartInterector = null;
    }
}
