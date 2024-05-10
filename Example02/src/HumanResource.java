import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.macquochuy.example02.entity.Employee;

public class HumanResource {
    private static SessionFactory factory;

    public static void main(String[] args) {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) {
            ex.printStackTrace();
        }
        HumanResource me = new HumanResource();
        
        Integer empID1 = me.addEmployee("Zara", "Ali", 1000);
        Integer empID2= me.addEmployee("Daisy", "Das", 5000);
        Integer empID3 = me.addEmployee("John", "Paul", 10000);
        
        me.listEmployees();
        me.updateEmployee (empID1, 5000);
        me.deleteEmployee (empID2);
        me.listEmployees();
}

    public Integer addEmployee (String fname, String Iname, int salary) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;
        try {
            tx = session.beginTransaction();
            Employee employee = new Employee (fname, Iname, salary);
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
            System.out.print("First Name:" + employee.getFirstName());
            System.out.print(" Last Name: " + employee.getLastName());
            System.out.println(" Salary: "+ employee.getSalary());
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

public void updateEmployee (Integer EmployeeID, int salary) {
    Session session = factory.openSession();
    Transaction tx = null;
    try {
        tx = session.beginTransaction();
        Employee employee = (Employee) session.get(Employee.class, EmployeeID);
        employee.setSalary (salary);
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

public void deleteEmployee (Integer EmployeeID) {
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