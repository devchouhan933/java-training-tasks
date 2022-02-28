package com.company.hibernate_assessment.question10;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "product_assessment")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custom-generator")
    @GenericGenerator(strategy = "com.company.day8.demo.CustomIdGenerator", name = "custom-generator")
    private Integer id;
    private String name;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Store store;

    public Product(String name, Store store) {
        this.name = name;
        this.store = store;
    }

    public Product() {
    }

    public Product(Integer id, String name, Store store) {
        this.id = id;
        this.name = name;
        this.store = store;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", store=" + store +
                '}';
    }
}