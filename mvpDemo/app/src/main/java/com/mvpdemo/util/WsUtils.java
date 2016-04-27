package com.mvpdemo.util;

import retrofit2.Retrofit;

public class WsUtils {
    public static final String STAGING_URL = "http://demo5015172.mockable.io/";
    public static final String BASE_URL = STAGING_URL;

    public static WebServices getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WsUtils.BASE_URL)
                .build();
        WebServices webServices = retrofit.create(WebServices.class);
        return webServices;
    }
}
