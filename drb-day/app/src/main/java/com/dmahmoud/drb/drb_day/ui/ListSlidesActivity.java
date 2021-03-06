package com.dmahmoud.drb.drb_day.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.dmahmoud.drb.drb_day.R;
import com.dmahmoud.drb.drb_day.model.Slide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class ListSlidesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_slides);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initSlideList();
    }

    void initSlideList(){
        final ListView slideList = (ListView) findViewById(R.id.list_slides);

        //slideList.setAdapter(new ListSlideAdapter(this, getSlides()));
        new AsyncTask<String, Integer, String>(){

            @Override
            protected String doInBackground(String... params) {
                HttpClient httpClient = new DefaultHttpClient();
                HttpGet httpget = new HttpGet("http://192.168.1.101:3000/api/slides");
                String result = null;
                ResponseHandler<String> responseHandler = new BasicResponseHandler();
                try {
                    result = httpClient.execute(httpget, responseHandler);
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return result;
            }

            @Override
            protected void onPostExecute(String result) {
                Gson gson = new GsonBuilder().create();
                Type slideType = new TypeToken<List<Slide>>() {}.getType();
                List<Slide> slides = gson.fromJson(result, slideType);
                slideList.setAdapter(new ListSlideAdapter(ListSlidesActivity.this, slides));
            }
        }.execute();
    }
}
