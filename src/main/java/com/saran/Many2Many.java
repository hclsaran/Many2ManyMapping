package com.saran;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
  
public class Many2Many {
  
    public static void main(String[] args) {
  
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
  
         
        Meeting meeting1 = new Meeting("Quaterly Sales meeting");
        Meeting meeting2 = new Meeting("Weekly Status meeting");
         
        Employee employee1 = new Employee("Sachin", "Tendulkar");
        Employee employee2 = new Employee("Brian", "Lara");
 
        employee1.getMeetings().add(meeting1);
        employee1.getMeetings().add(meeting2);
        employee2.getMeetings().add(meeting1);
        
        
         
        session.save(employee1);
        session.save(employee2);
         
        session.getTransaction().commit();
        session.close();
    }
}
