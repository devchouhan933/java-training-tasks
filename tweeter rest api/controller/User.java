package com.company.rest.example.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

class User {

    private String name;
    private Integer userid;
    private String password;
    private List<Follower> followers= new ArrayList<>();

    public User(String name, Integer userid, String password) {
        this.name = name;
        this.userid = userid;
        this.password = password;
    }

    public User(String name, Integer userid, String password, List<Follower> followers) {
        this.name = name;
        this.userid = userid;
        this.password = password;
        this.followers = followers;
    }

    public User() {
    }

    public User(String name, Integer userid, List<Follower> followers) {
        this.name = name;
        this.userid = userid;
        this.followers = followers;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", userid=" + userid +
                ", password='" + password + '\'' +
                ", followers=" + followers +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public List<Follower> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Follower> followers) {
        this.followers = followers;
    }
}

class Follower {
    private Integer followerUserId;

    public Follower() {
    }

    public Follower(Integer followerUserId) {
        this.followerUserId = followerUserId;
    }

    @Override
    public String toString() {
        return "Follower{" +
                "followerUserId=" + followerUserId +
                '}';
    }

    public Integer getFollowerUserId() {
        return followerUserId;
    }

    public void setFollowerUserId(Integer followerUserId) {
        this.followerUserId = followerUserId;
    }
}

class Tweet {
    private String tweet;
    private Integer userId;
    private Timestamp timestamp;

    public Tweet(String tweet, Integer userId, Timestamp timestamp) {
        this.tweet = tweet;
        this.userId = userId;
        this.timestamp = timestamp;
    }

    public Tweet(String tweet, Integer userId) {
        this.tweet = tweet;
        this.userId = userId;
    }

    public Tweet() {
    }

    public Tweet(String tweet) {
        this.tweet = tweet;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp
                                     timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Tweets{" +
                "tweet='" + tweet + '\'' +
                ", userId=" + userId +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }
}

