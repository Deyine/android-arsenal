package com.dmahmoud.drb.drb_day.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.Toast;

import com.dmahmoud.drb.drb_day.R;
import com.dmahmoud.drb.drb_day.model.Slide;
import com.dmahmoud.drb.drb_day.service.DrbClient;
import com.dmahmoud.drb.drb_day.service.RestClientListener;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.RetrofitError;

public class ListSlidesActivity extends AppCompatActivity implements RestClientListener<List<Slide>> {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.list_slides)
    ListView slideList;

    DrbClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_slides);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        client = new DrbClient();
        initSlideList();
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }

    void initSlideList(){
        client.getSlides(this);
    }

    @Override
    public void onSuccess(List<Slide> object) {
        slideList.setAdapter(new ListSlideAdapter(this, object));
    }

    @Override
    public void onError(RetrofitError error) {
        Toast.makeText(this, "Error occured, Aie !!" + error.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
