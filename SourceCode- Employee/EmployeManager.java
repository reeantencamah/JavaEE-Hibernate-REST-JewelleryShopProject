package ewel;

//import java.util.Collection;
//import java.util.ArrayList;
//import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class EmployeManager {
	
	private SessionFactory sessionFactory;
		
		@SuppressWarnings("deprecation")
		public EmployeManager() throws Exception{
			
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		
		
		public int addEmployee(String fname,String lname,String gender,String address,int pNum,String position) {
			Session session= sessionFactory.openSession();
			Transaction tx= session.beginTransaction();
			Employee myEmp= new Employee();
			myEmp.setFname(fname);
			myEmp.setLname(lname);
			myEmp.setGender(gender);
			myEmp.setAddress(address);
			myEmp.setpNum(pNum);
			myEmp.setPosition(position);
			int EmpID= (Integer)session.save(myEmp);
			
			tx.commit();
			session.close();
			return EmpID;
		}
		
		public void deleteEmployee(String fname) {
			Session session = sessionFactory.openSession();
			Transaction tx= session.beginTransaction();
			Employee myEmp=(Employee)session.get(Employee.class,fname);
			session.delete(myEmp);
			tx.commit();
			session.close();
		}
		
		public void updateEmployee(String fname,String lname,String gender,String address,int pNum,String position) {
			Session session= sessionFactory.openSession();
			Transaction tx= session.beginTransaction();
			Employee myEmp= new Employee();
			myEmp.setFname(fname);
			myEmp.setLname(lname);
			myEmp.setGender(gender);
			myEmp.setAddress(address);
			myEmp.setpNum(pNum);
			myEmp.setPosition(position);
			
			session.update(myEmp);
			tx.commit();
			session.close();
		}
		

		public Employee getUser(int id) {
			Employee emp = null;
			Session session = ((org.hibernate.SessionFactory) sessionFactory).openSession();
			Transaction tx = session.beginTransaction();
			String hql = "from Employee where id=:id ";
			Query query = session.createQuery(hql);
			query.setInteger("id", id);			
			emp=(Employee) query.uniqueResult();
		      
			tx.commit();
		    session.close();
			return emp ;
		}
		
//		public Employee getEmpid(int id) {
//			Session session = ((org.hibernate.SessionFactory) sessionFactory).openSession();
//			Transaction tx = session.beginTransaction();
//			String hql = "from Employee where id=:id";
//			Query query = session.createQuery(hql);
//			query.setInteger("id", id);
//			tx.commit();
//		    session.close();
//			return (Employee)query.list();
//		}
		
//		@SuppressWarnings("unchecked")
//		public ArrayList<Employee> getid(){
//			Session session = ((org.hibernate.SessionFactory) sessionFactory).openSession();
//			Transaction tx = session.beginTransaction();
//			ArrayList<Employee> empid=(ArrayList<Employee>) session.createQuery("from Employee").list();
//			tx.commit();
//		    session.close();
//		    return empid;
//		}
		
}
