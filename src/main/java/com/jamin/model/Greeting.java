package com.jamin.model;

/**
 * Server --> Client
 */
public class Greeting {

    private String userId;

    private String content;

    public Greeting() {
    }

    public Greeting(String userId, String content) {
        this.userId = userId;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
