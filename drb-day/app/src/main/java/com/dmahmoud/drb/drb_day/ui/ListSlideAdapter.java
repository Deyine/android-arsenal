package com.dmahmoud.drb.drb_day.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dmahmoud.drb.drb_day.R;
import com.dmahmoud.drb.drb_day.model.Slide;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by djiddou on 4/20/16.
 */
public class ListSlideAdapter extends ArrayAdapter<Slide> {

    List<Slide> slides;

    public ListSlideAdapter(Context context, List<Slide> slides) {
        super(context, 0, slides);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.slide_item,parent, false);
        }

        SlideViewHolder viewHolder = (SlideViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new SlideViewHolder(convertView);
            convertView.setTag(viewHolder);
        }

        Slide slide = getItem(position);

        viewHolder.title.setText(slide.getTitle());
        viewHolder.desc.setText(slide.getSpeaker());
        new DownloadImageTask(viewHolder.image).execute("http://pipsum.com/100x100.jpg");
        return convertView;
    }

    static class SlideViewHolder{
        @Bind(R.id.slide_title)
        public TextView title;
        @Bind(R.id.slide_desc)
        public TextView desc;
        @Bind(R.id.slide_image)
        public ImageView image;

        public SlideViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    // From AndroidDeveloper
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
