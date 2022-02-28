package com.company.hibernate_assessment.question7;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.factory.spi.StandardGenerator;

   /*
          public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
            Session session2= day10.Utility.getSession();
            Long numberOfRecords = session2.createQuery("select count(name) from Product",Long.class).getSingleResult();
            //System.out.println(numberOfRecords);
            return (numberOfRecords+1);
        }

        * */


public class CustomId implements StandardGenerator {
    private final String DEFAULT_SEQUENCE_NAME = "product_seq";

    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        Session session = Question_7.getSession();
        Integer nextId = session.createQuery("select max(id) from Product", Integer.class).getSingleResult();
        if (nextId == null) {
            nextId = 1;
            return nextId;
        }
        return (nextId.intValue() + 1);
    }
}
