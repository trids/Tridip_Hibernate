package org.learn.trids_mavenLearning;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;


//@SuppressWarnings("deprecation")
public class UserDao {
	private static SessionFactory sessionFactory;
	//@SuppressWarnings("deprecation")
	public static void main(String[] args) {   			//main method**
		  try {
			  sessionFactory = new AnnotationConfiguration().
		                   configure().
		                   //addPackage("com.xyz") //add package if used.
		                   addAnnotatedClass(UserEntity.class).
		                   buildSessionFactory();
			  UserDao dao=new UserDao();
			  dao.addUser();
			  dao.deleteUser();
			 // dao.getUser();
		      } catch (Throwable ex) { 
		         System.err.println("Failed to create sessionFactory object." + ex);
		         throw new ExceptionInInitializerError(ex); 
		      }
		      
	}
	 public void addUser(){
	      Session session = sessionFactory.openSession();
	      Transaction tx = null;
	    //  Integer uID = null;         // to be used if save method id used as return type is integer...
	      
	      try {
	         tx = session.beginTransaction();
	         UserEntity userEntity=new UserEntity();
	         userEntity.setUSERID("5");
	         System.out.println("upto userid");
	         userEntity.setName("new");
	     //    System.out.println("upto setUserName");
	    //     uID = Integer.parseInt(session.save(userEntity).toString()); 
	         session.persist(userEntity);
	         tx.commit();
	      } catch (HibernateException e) {
	    	  System.out.println("in catch");
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      System.out.println("yes");
	     // return uID;
	   }
	 public void deleteUser(){
	      Session session = sessionFactory.openSession();
	      Transaction tx = null;
	  //    Integer uID = null;
	      
	      try {
	         tx = session.beginTransaction();
	           UserEntity userEntity=new UserEntity();
	          userEntity.setUSERID("3");
	         System.out.println("upto userid");
	     //    userEntity.setUserName("dip");
	     //    System.out.println("upto setUserName");
	    //     uID = Integer.parseInt(session.save(userEntity).toString()); 
	         session.delete(userEntity);
	         tx.commit();
	      } catch (HibernateException e) {
	    	  System.out.println("in catch");
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      System.out.println("yes");
	    //  return uID;
	   }
	 public void getUser() {
		
	 }
	 
	 public void updateUser(){
	     
	   }

}
