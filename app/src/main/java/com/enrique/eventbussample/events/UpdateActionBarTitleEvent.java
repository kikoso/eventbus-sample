package com.enrique.eventbussample.events;

public class UpdateActionBarTitleEvent {

    private String title;

    public UpdateActionBarTitleEvent(String title) {
        this.title = title;
    }


    public String getTitle() {
        return title;
    }
}

