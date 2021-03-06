package com.sendi.userdb;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "USER".
 */
public class User {

    private Long id;
    private String user_nickname;
    private String user_id;
    private String user_pic_url;
    private String phone_number;
    private String gander;
    private String hobbies;

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(Long id, String user_nickname, String user_id, String user_pic_url, String phone_number, String gander, String hobbies) {
        this.id = id;
        this.user_nickname = user_nickname;
        this.user_id = user_id;
        this.user_pic_url = user_pic_url;
        this.phone_number = phone_number;
        this.gander = gander;
        this.hobbies = hobbies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_pic_url() {
        return user_pic_url;
    }

    public void setUser_pic_url(String user_pic_url) {
        this.user_pic_url = user_pic_url;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getGander() {
        return gander;
    }

    public void setGander(String gander) {
        this.gander = gander;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

}
