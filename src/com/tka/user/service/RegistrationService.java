package com.tka.user.service;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;

import com.tka.user.dao.RegistrationDao;
import com.tka.user.entity.User;
import com.tka.user.security.Encrypt;
import com.tka.user.utility.MailSender;
import com.tka.user.varification.VarifyUserDetail;

public class RegistrationService {

	RegistrationDao dao=new RegistrationDao();
	
	
	


	public String registerUser(User u) {
		// TODO Auto-generated method stub
		 
		if(VarifyUserDetail.varifyEmail(u.getEmail())&&VarifyUserDetail.varifyPassword(u.getPassword()))
		{		
			
			String passWord=u.getPassword();
			
			u.setPassword(Encrypt.encryptMyPass(passWord));
			
			u.setDateOfCreation(LocalDateTime.now());
		    u.setDateOfModification(LocalDateTime.now());
   
	       	     
           List<String> emails=  dao.getAllEmails();
		    
               if(!emails.contains(u.getEmail()))
               {
        	       return  dao.registerUser(u);
               }
               
               else
               {
            	   return "DUPLICATE EMAIL FOUND TRY WITH ANOTHER ...!";
               }
			
			
			
			
		}
		
		else
		{
			return "Email  OR PASSWORD NOT MATCHING ";
		}
		
		
		
		
		
	}
    
	public String loginUser(User u) {
		// TODO Auto-generated method stub
	       
		String enc=Encrypt.encryptMyPass(u.getPassword());
		
		    u.setPassword(enc);
		       
            User user =dao.cheackLoginUser(u);
            
         if(user!=null &&  u.getEmail().equals(user.getEmail()) && enc.equals(user.getPassword()))
		        {
		        	return  "User Logged In Successfullly";
		        } 
		        else
		        {
		        	return "INVALID CREDENTIALS...! ";
		        }
	        
	       
	             
		
		 
	}

	public String resetPassword(String email,String newPass) {
		// TODO Auto-generated method stub
		  
		List<String> emails=dao.getAllEmails();
		   
		if(emails.contains(email))
		{
			
			String encPass=Encrypt.encryptMyPass(newPass);
			
		    boolean b=dao.updatePassword(email,encPass);
			
		    
		    if(b)
		    {
		    	MailSender.sendEmail(email, newPass); 
		    	
		    	return "Password Reset Sussessfull Cheack Your Mail";
		    }
		    else
		    	
		    {
		    	return "password reset error";
		    }
		    
		    
		}
		else
		{
	
			return "NOT FOUND";
		}
		
		
		
		 
		
		
	
	}

	
	
}
