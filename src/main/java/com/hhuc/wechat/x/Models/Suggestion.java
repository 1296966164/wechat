package com.hhuc.wechat.x.Models;

/**
 * @program: pt
 * @description: 用户模型
 * @author: LYX
 * @create: 2019-02-20 15:44
 **/

import java.util.*;
import java.text.*;


public class Suggestion {

    private String time;
    private String content;
    private String contact;
    private String towho;
    private String uuid;


    public Suggestion() {
    }


    public Suggestion(String content, String contact, String towho) {
        this.content = content;
        this.contact = contact;
        this.towho = towho;
        Date dNow = new Date();
        SimpleDateFormat ft =
                new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        this.time = ft.format(dNow);
        UUID uuid = UUID.randomUUID();
        this.uuid = uuid.toString();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTowho() {
        return towho;
    }

    public void setTowho(String towho) {
        this.towho = towho;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"time\":\"")
                .append(time).append('\"');
        sb.append(",\"content\":\"")
                .append(content).append('\"');
        sb.append(",\"contact\":\"")
                .append(contact).append('\"');
        sb.append(",\"towho\":\"")
                .append(towho).append('\"');
        sb.append(",\"uuid\":\"")
                .append(uuid).append('\"');
        sb.append('}');
        return sb.toString();
    }


}

