package edu.upc.dsa.retrofit4;

import java.io.Serializable;

public class UserResponse implements Serializable {

    private String id;
    private String singer;
    private  String title;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UserResponse(String id, String singer, String title) {
        this.id = id;
        this.singer = singer;
        this.title = title;
    }


    @Override
    public String toString() {
        return "UserResponse{" +
                "id='" + id + '\'' +
                ", singer='" + singer + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}

