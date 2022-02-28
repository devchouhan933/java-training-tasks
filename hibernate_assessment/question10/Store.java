package com.company.hibernate_assessment.question10;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "store_assessment")
public class Store {
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private  Set<Product> products = new HashSet<>();
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custom-generator")
    @GenericGenerator(strategy = "com.company.day8.demo.CustomIdGenerator", name = "custom-generator")
    private Integer id;
    private String name;
    private String address;

    public Store() {
    }

    public Store(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Set<Product> getProducts() {
        return products;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", products=" + products +
                '}';
    }
}