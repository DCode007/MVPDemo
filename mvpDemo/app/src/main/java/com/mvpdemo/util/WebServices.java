package com.mvpdemo.util;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.POST;

public interface WebServices {

    @POST("gson-mock")
    Call<ResponseBody> getCardDetails();
}
