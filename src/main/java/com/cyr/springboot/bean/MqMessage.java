package com.cyr.springboot.bean;

public class MqMessage {
    private String queue;

    private String message;

    public String getQueue () {
        return queue;
    }

    public void setQueue (String queue) {
        this.queue = queue;
    }

    public String getMessage () {
        return message;
    }

    public void setMessage (String message) {
        this.message = message;
    }
}
