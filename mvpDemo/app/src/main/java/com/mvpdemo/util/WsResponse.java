package com.mvpdemo.util;

public interface WsResponse {
    void onSuccess(String response, int requestCode, int responseCode);

    void onError(String response, int requestCode, int responseCode);
}
