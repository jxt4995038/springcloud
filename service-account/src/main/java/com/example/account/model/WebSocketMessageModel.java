package com.example.account.model;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2020-03-18 15:37
 */
public class WebSocketMessageModel {
    private int type;
    private String content;

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}