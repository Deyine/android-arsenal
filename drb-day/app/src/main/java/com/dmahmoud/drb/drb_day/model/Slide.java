package com.dmahmoud.drb.drb_day.model;

/**
 * Created by djiddou on 4/20/16.
 */
public class Slide {

    String title;

    String description;

    String speaker;

    String image;

    public Slide(String title, String description, String image, String speaker) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.speaker = speaker;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }
}
