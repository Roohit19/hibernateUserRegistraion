package com.tka.user.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tka.user.entity.User;

public final class HibernateConfig {
    
  public static SessionFactory getSessionFactory()
  { 
	  
	  SessionFactory sf=new Configuration().configure().addAnnotatedClass(User.class).buildSessionFactory();
	  
	  
	  
	  
	  return sf;
  }
	
	
}
