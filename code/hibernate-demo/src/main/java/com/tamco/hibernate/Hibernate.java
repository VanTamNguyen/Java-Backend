package com.tamco.hibernate;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;

import java.util.List;

public class Hibernate {

    private static Configuration configuration;

    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Person.class);
        configuration.addAnnotatedClass(BankAccount.class);
        sessionFactory = configuration.buildSessionFactory();

        // Save some people with bank accounts
        savePeopleWithBankAccounts();

        // Order people by salary
        orderPeopleBySalary();

        // Clear database
        deletePeople();
    }

    private static void deletePeople() {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Criteria criteria = session.createCriteria(Person.class);
            List<Person> people = criteria.list();
            for (Person person : people) {
                session.delete(person);
            }

            transaction.commit();
            System.out.println("The database has been cleared");

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        } finally {
            if (session != null) {
                session.close();
                System.out.println("Always close the session after done with database\n***************************************");
            }
        }
    }

    private static void savePeopleWithBankAccounts() {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Person jame = new Person("Jame Bond", 2000);
            BankAccount account1 = new BankAccount("100011", 1000);
            BankAccount account2 = new BankAccount("100012", 1000);

            session.save(jame);
            account1.setPerson(jame);
            account2.setPerson(jame);

            session.save(account1);
            session.save(account2);

            Person john = new Person("John Wick", 10000);
            BankAccount account3 = new BankAccount("100013", 1000000);
            account3.setPerson(john);
            session.save(john);
            session.save(account3);

            transaction.commit();
            System.out.println("Person with bank accounts has been saved!");

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Person with bank accounts save failed! " + e.getMessage());

        } finally {
            if (session != null) {
                session.close();
            }
            System.out.println("Always close the session after done with database\n***************************************");
        }
    }

    private static void orderPeopleBySalary() {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Criteria criteria = session.createCriteria(Person.class);
            criteria.addOrder(Order.desc("salary"));
            List<Person> people = criteria.list();
            for (Person person : people) {
                System.out.println("Person[" + person.getName() + ", " + person.getSalary() + "]");
            }

            transaction.commit();
            System.out.println("People have been ordered");

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

        } finally {
            if (session != null) {
                session.close();
            }
            System.out.println("Always close the session after done with database\n***************************************");
        }
    }
}
