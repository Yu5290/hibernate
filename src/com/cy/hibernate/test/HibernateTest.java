package com.cy.hibernate.test;

import com.cy.hibernate.entity.User;
import com.cy.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class HibernateTest {

    private Session session;
    Transaction transaction;

    @Before
    public void before(){
        session= HibernateUtils.getCurrentSession();
        transaction = session.beginTransaction();
    }

    @After
    public void after(){
        transaction.commit();
        session.close();
    }

    @Test
    public void save() {
        User user = new User("a", "b3");
        session.save(user);
    }

    @Test
    public void get() {
        User user = session.get(User.class,6);
        System.out.println(user);
    }

    @Test
    public void load() {
        User user = session.load(User.class, 2);
        System.out.println(user);
    }

    @Test
    public void delete() {
        User user = session.get(User.class, 1);
        session.delete(user);
    }

    @Test
    public void delete2() {
        User user = new User(3);
        session.delete(user);
    }

    @Test
    public void update() {
        User user = session.get(User.class, 5);
        user.setPassWord("ooo112323");
        session.update(user);
    }

    @Test
    public void update2() {
        User user = new User(4, "123", "123");
        session.update(user);
    }

    @Test
    public void all() {
        Query query=session.createQuery("from User");
        query.setFirstResult(5);
        query.setMaxResults(5);
        List<User> users=query.list();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void all2() {

    }
}
