package com.tka.user.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.tka.user.configuration.HibernateConfig;
import com.tka.user.entity.User;

public class RegistrationDao {

	
   SessionFactory sf=HibernateConfig.getSessionFactory();
	
	
	
	

	public String registerUser(User u) {
		// TODO Auto-generated method stub
	  
		Session session=sf.openSession();
		
		session.save(u);
		
		session.beginTransaction().commit();
	    
		session.close();
		
	    return "Registration SuccessFull...!!";
	}





	public List<String> getAllEmails() {
		// TODO Auto-generated method stub
		
		Session session=sf.openSession();
		 
		Criteria c=session.createCriteria(User.class);
		 c.setProjection(Projections.property("email"));
		 
		 List<String > list=c.list();
 		
		
		
		
		return list;
	}
  
	   public User cheackLoginUser(User u) {
            		
		   Session s = sf.openSession();
		    User user = null;

		    
		        Criteria c = s.createCriteria(User.class);
		        c.add(Restrictions.eq("email", u.getEmail()));
		        c.add(Restrictions.eq("password", u.getPassword()));

		        user = (User) c.uniqueResult();

		        if (user != null) {
		           
		        	return user;
		        } else {
		            
		           return null;
		        } 
		        
	   
	   }





	public boolean updatePassword(String email,String newPass) {
		// TODO Auto-generated method stub
		Session s =sf.openSession();
		Criteria c=s.createCriteria(User.class);
		
		  c.add(Restrictions.eq("email", email));
		  
		  User u=(User)c.uniqueResult();
		  
		  if(u!=null)
		  {
			  
			  u.setPassword(newPass);
              s.update(u);
              s.beginTransaction().commit();
              s.clear();
			  return true;
		  }
		  
		  else
		  {
			  return false;
		  }
		  
		
		
		
		
		
		
		     
	}

}
