package com.dmahmoud.drb.drb_day.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dmahmoud.drb.drb_day.R;
import com.dmahmoud.drb.drb_day.model.Slide;

import java.util.List;

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
            viewHolder = new SlideViewHolder();
            viewHolder.title = (TextView) convertView.findViewById(R.id.slide_title);
            viewHolder.desc = (TextView) convertView.findViewById(R.id.slide_desc);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.slide_image);
            convertView.setTag(viewHolder);
        }

        Slide slide = getItem(position);

        viewHolder.title.setText(slide.getTitle());
        viewHolder.desc.setText(slide.getDescription());
        viewHolder.image.setImageDrawable(new ColorDrawable(Color.GRAY));

        return convertView;
    }

    private class SlideViewHolder{
        public TextView title;
        public TextView desc;
        public ImageView image;
    }
}
