package com.company.hibernate_assessment.question9;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "cat_assessment")
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custom-generator")
    @GenericGenerator(strategy = "com.company.day8.demo.CustomIdGenerator", name = "custom-generator")
    private Integer id;
    private String name;
    private int weight;
    private int age;

    public Cat() {

    }

    public Cat(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                '}';
    }

    public int getWeight(int i) {
        this.weight = i;
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}