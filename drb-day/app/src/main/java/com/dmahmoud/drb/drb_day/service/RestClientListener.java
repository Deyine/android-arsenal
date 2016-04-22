package com.dmahmoud.drb.drb_day.service;

import retrofit.RetrofitError;

/**
 * Created by dmahmoud on 22/04/16.
 */
public interface RestClientListener<T> {

    void onSuccess(T object);

    void onError(RetrofitError error);

}
