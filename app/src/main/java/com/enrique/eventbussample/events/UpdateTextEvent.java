package com.enrique.eventbussample.events;

public class UpdateTextEvent {

    private String newText;


    public UpdateTextEvent(String newText) {
        this.newText = newText;
    }

    public String getTitle() {
        return newText;
    }
}
