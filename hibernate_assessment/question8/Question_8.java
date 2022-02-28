package com.company.hibernate_assessment.question8;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Question_8 {
    public static void main(String[] args) {
        // insertRecords();

        fetch();
    }

    public static Session getSession() {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(User.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
    }

    private static void fetch() {
        Session session = getSession();
        List<Object[]> users = session.createQuery
                ("select id,message,userId,count(message)  from User group by userId ORDER BY count(message) DESC limit 1", Object[].class).list();
        users.forEach(user -> System.out.println("id -> " + user[0] + "  message - " + user[1] + "  userId - " + user[2] + "  count - " + user[3]));


    }


    private static void insertRecords() {
        Session session = getSession();
        String[] names = new String[]{"user-1", "user-2", "user-3", "user-4"};
        Transaction transaction = session.beginTransaction();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUserId(names[(int) (Math.random() * 4)]);
            user.setMessage("message  -> " + (Math.random() * 100));
            session.persist(user);
        }
        transaction.commit();
        session.close();
    }


}
