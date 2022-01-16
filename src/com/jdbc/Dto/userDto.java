package com.jdbc.Dto;

public class userDto {
    private int id;
    private String username;
    private String password;

    public userDto() {
    }

    public userDto(int id) {
        this.id = id;
    }

    public userDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public userDto(int id, String password) {
        this.id = id;
        this.password = password;
    }

    public userDto(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "userDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
