package com.company.hibernate_assessment.Question4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.stream.Collectors;

public class CRUDExample {
    public static void main(String[] args) {
        //  insertData();
//        readProduct();
        updateExample();
//deleteExample();

    }

    // R
    private static void readProduct() {
        Session session = getSession();
        List<Product> productList = session.createQuery("from Product", Product.class).getResultList().stream().filter(product -> product.getAmount() > 100).collect(Collectors.toList());
        System.out.println(productList);
    }

    // D
    private static void deleteExample() {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("from  Product where amount < 10", Product.class).getResultList().forEach(product -> session.remove(product));
        transaction.commit();
    }

    // C
    private static void insertData() {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Product product = new Product("product-1", -11);
        Product product1 = new Product("product-2", -1);
        Product product2 = new Product("product-4", 1);
        Product product3 = new Product("product-5", 2);
        Product product4 = new Product("product-6", 110);
        Product product5 = new Product("product-6", 100);
        Product product7 = new Product("product-7", 200);
        session.persist(product);
        session.persist(product1);
        session.persist(product3);
        session.persist(product2);
        session.persist(product4);
        session.persist(product5);
        session.persist(product7);
        transaction.commit();
    }

    // U
    private static void updateExample() {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("from Product where amount < 0", Product.class).getResultList().stream().map(product -> {
            product.setAmount(10);
            return product;
        }).collect(Collectors.toList()).forEach(product -> session.persist(product));
        transaction.commit();
        session.close();
    }

    private static Session getSession() {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Product.class);
        //  configuration.addResource("Product.hbm.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
    }

}