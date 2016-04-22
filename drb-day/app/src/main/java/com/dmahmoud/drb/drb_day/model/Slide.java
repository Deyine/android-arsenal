package com.dmahmoud.drb.drb_day.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by djiddou on 4/20/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Slide {

    @JsonProperty("title")
    String title;

    @JsonProperty("description")
    String description;

    @JsonProperty("speaker")
    String speaker;

    public Slide() {
    }

    public Slide(String title, String description, String speaker) {
        this.title = title;
        this.description = description;
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

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }
}
