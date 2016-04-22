package com.dmahmoud.drb.drb_day.service;

import com.dmahmoud.drb.drb_day.model.Slide;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.JacksonConverter;

/**
 * Created by dmahmoud on 22/04/16.
 */
public class DrbClient {

    public void getSlides(final RestClientListener<List<Slide>> listener){
        RestAdapter rest = new RestAdapter.Builder()
                                    .setConverter(new JacksonConverter(new ObjectMapper()))
                                    .setEndpoint("http://192.168.102.96:3000")
                                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                                    .build();
        DrbService service = rest.create(DrbService.class);
        service.getSlides(new Callback<List<Slide>>() {
            @Override
            public void success(List<Slide> slides, Response response) {
                listener.onSuccess(slides);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onError(error);
            }
        });
    }

}
