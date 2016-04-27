package com.mvpdemo.Cart;

import android.util.Log;

import com.google.gson.Gson;
import com.mvpdemo.model.Cart;
import com.mvpdemo.util.WebServices;
import com.mvpdemo.util.WsUtils;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartInterectorImpl implements CartInterector {
    public static String TAG = "CartInterectorImpl";

    @Override
    public void getCardRest(final OnCartLoaded onCartLoaded, final int requestCode, final int responseCode) {
        Log.i(TAG, "ws call start");
        WebServices webServices = WsUtils.getRetrofit();
        Call<ResponseBody> cartCall = webServices.getCardDetails();
        cartCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String resp = response.body().string();
                    Log.i(TAG, "onResponse: " + resp);
                    Gson gson = new Gson();
                    Cart cart = gson.fromJson(resp, Cart.class);
                    onCartLoaded.onSuccess(cart, requestCode, responseCode);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.i(TAG, "onFailure");
                onCartLoaded.onError(null, requestCode, responseCode);
            }
        });


    }
}
