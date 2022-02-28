package com.company.hibernate_assessment.question8;
import jakarta.persistence.*;


@Entity
@Table(name =  "user_records")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userId;
    private String message;

    public User() {
    }

    public User(String userId, String message) {
        this.userId = userId;
        this.message = message;
    }

    public User(Integer id, String userId, String message) {
        this.id = id;
        this.userId = userId;
        this.message = message;
    }

    @Override
    public String toString() {
        return "message{" + "id=" + id + ", userId='" + userId + '\'' + ", message='" + message + '\'' + '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
