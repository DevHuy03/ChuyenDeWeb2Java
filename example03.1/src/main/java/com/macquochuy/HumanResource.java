package com.macquochuy;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.macquochuy.example03.entity.Employee;

public class HumanResource {
    private static SessionFactory factory;

    public static void main(String[] args) {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Employee.class);

            factory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            ex.printStackTrace();
            return; // Add return here to stop execution if SessionFactory creation fails
        }

        HumanResource me = new HumanResource();
        System.out.println("------------Add New 3 Employee------------");
        Integer empID1 = me.addEmployee("Tuan", "Nguyen", 1000);
        Integer empID2 = me.addEmployee("Phat", "Huynh", 5000);
        Integer empID3 = me.addEmployee("Nam", "Tran", 10000);
        System.out.println("------------List Employees------------");
        me.listEmployees();
        System.out.println("------------Update Employee------------");
        me.updateEmployee(empID1, 5000);
        System.out.println("------------Deleted Employee------------");
        me.deleteEmployee(empID2);
        System.out.println("------------List Employees------------");
        me.listEmployees();
    }

    public Integer addEmployee(String fname, String lname, int salary) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;
        try {
            tx = session.beginTransaction();
            Employee employee = new Employee(fname, lname, salary);
            employeeID = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeID;
    }

    public void listEmployees() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM Employee").list();
            for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
                Employee employee = (Employee) iterator.next();
                System.out.print("First Name: " + employee.getFirstName());
                System.out.print("Last Name: " + employee.getLastName());
                System.out.println("Salary: " + employee.getSalary());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
} finally {
            session.close();
        }
    }

    public void updateEmployee(Integer EmployeeID, int salary) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Employee employee = (Employee) session.get(Employee.class, EmployeeID);
            employee.setSalary(salary);
            session.update(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteEmployee(Integer EmployeeID) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Employee employee = (Employee) session.get(Employee.class, EmployeeID);
            session.delete(employee);
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