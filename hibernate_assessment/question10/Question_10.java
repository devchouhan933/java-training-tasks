package com.company.hibernate_assessment.question10;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Question_10 {
    public static void main(String[] args) {
        // insert();

        remove();
    }

    private static void remove() {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Store store = session.get(Store.class, 10412);
        session.remove(store);
        transaction.commit();
        session.close();
    }

    private static void insert() {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Store store = new Store();
        store.setName("store_1");
        store.setAddress("address_1");

        Product product = new Product();
        product.setName("product_2");
        product.setStore(store);
        session.persist(product);
        transaction.commit();
        session.close();
    }

    public static Session getSession() {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Store.class);
        configuration.addAnnotatedClass(Product.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
    }

}
