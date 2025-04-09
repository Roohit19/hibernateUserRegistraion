package com.tka.user.varification;

public class VarifyUserDetail {
 
	
	public static final boolean varifyEmail(String email)
	{
		
		if(email.contains("@"))
		{
			return true;
		}
		else
		{
			return false;
			
		}
		
		
	}
	
	
public	static final boolean varifyPassword(String password)
	{
		
		if(password.length()>=8)
		{
			return true;
		}
		else
		{
			
			 System.out.println("Password not correct");
		return false;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
