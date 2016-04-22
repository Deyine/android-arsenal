package com.dmahmoud.drb.drb_day.service;

import com.dmahmoud.drb.drb_day.model.Slide;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by dmahmoud on 22/04/16.
 */
public interface DrbService {

    @GET("/api/slides")
    public void getSlides(Callback<List<Slide>> cb);
}
