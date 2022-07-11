package com.websocket;

public class SubmitMessage {

    private String message;

    public SubmitMessage() {

    }

    public SubmitMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
