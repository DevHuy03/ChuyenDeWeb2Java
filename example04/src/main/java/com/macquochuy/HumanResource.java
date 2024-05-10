package com.macquochuy;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.macquochuy.entity.Department;
import com.macquochuy.entity.Employee;

public class HumanResource {
    private static SessionFactory factory;

    public static void main(String[] args) {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Employee.class);
            configuration.addAnnotatedClass(Department.class);
            factory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            System.out.println("--------Add New 2 Department--------------");
            Department depIT = new Department("IT");
            session.save(depIT);

            Department depSales = new Department("Sales");
            session.save(depSales);

            System.out.println("---------Add New 3 Employee---------------");
            Employee emp1 = new Employee("Tuan", "Nguyen", 1000);
            emp1.setDepartment(depIT);
            session.save(emp1);

            Employee emp2 = new Employee("Phat", "Huynh", 5000);
            emp2.setDepartment(depSales);
            session.save(emp2);

            Employee emp3 = new Employee("Nam", "Tran", 10000);
            emp3.setDepartment(depSales);
            session.save(emp3);

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}