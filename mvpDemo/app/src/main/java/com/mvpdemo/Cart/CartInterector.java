package com.mvpdemo.Cart;


import com.mvpdemo.model.Cart;
import com.mvpdemo.util.WsResponse;

public interface CartInterector {
    interface OnCartLoaded extends WsResponse {
        void onSuccess(Cart cart, int requestCode, int responseCode);
    }

    void getCardRest(OnCartLoaded onCartLoaded, int requestCode, int responseCode);

}