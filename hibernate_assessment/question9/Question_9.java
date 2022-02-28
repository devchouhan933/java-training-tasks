package com.company.hibernate_assessment.question9;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Question_9 {
    public static void main(String[] args) {
        insert();
        Session session = getSession();

        CriteriaQuery<Cat> criteriaQuery = fetchData(session);
        System.out.println(session.createQuery(criteriaQuery).getResultList());
    }

    private static CriteriaQuery<Cat> fetchData(Session session) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Cat> criteriaQuery = criteriaBuilder.createQuery(Cat.class);
        Root<Cat> root = criteriaQuery.from(Cat.class);
        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("age")));

        criteriaQuery.select(root).where(criteriaBuilder
                .and(criteriaBuilder.like(root.get("name"), "m%"), criteriaBuilder.gt(root.get("weight"), 2)));

        return criteriaQuery;

    }

    public static Session getSession() {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Cat.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
    }

    public static void insert() {
        Session session = getSession();
        String[] catNames = new String[]{"cat-1", "cat-2", "cat-3", "cat-4", "cat-5"};
        Transaction transaction = session.beginTransaction();
        for (int i = 0; i < 100; i++) {
            Cat cat = new Cat();
            cat.setName(catNames[(int) (Math.random() * 4)]);
            cat.getWeight((int) (Math.random() * 10));
            cat.setAge((int) (Math.random() * 10));
            session.persist(cat);
        }
        transaction.commit();
        session.close();
    }
}