package com.cyr.springboot.demo.WebSocket;

public class MessageResponse {
    private String responseMessage;

    public MessageResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
