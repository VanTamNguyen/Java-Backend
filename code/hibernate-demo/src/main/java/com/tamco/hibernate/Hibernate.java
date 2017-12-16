package com.tamco.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Hibernate {

    private static Configuration configuration;

    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Person.class);
        configuration.addAnnotatedClass(BankAccount.class);
        sessionFactory = configuration.buildSessionFactory();

        savePersonWithBankAcounts();
    }

    private static void savePersonWithBankAcounts() {
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

            transaction.commit();
            System.out.println("Person with bank accounts has been saved!");

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            System.out.println("Person with bank accounts save failed! " + e.getMessage());

        } finally {
            if (session != null) {
                session.close();
            }
            System.out.println("Always close the session after done with database\n***************************************");
        }
    }
}
