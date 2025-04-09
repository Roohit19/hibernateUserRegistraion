package com.tka.user.controller;

import com.tka.user.entity.User;
import com.tka.user.service.RegistrationService;

public class RegisterController {

	RegistrationService service=new RegistrationService();
	
 	public String registerUser(User u) {
		// TODO Auto-generated method stub
    		return service.registerUser(u);		
	}

	public String loginUser(User u) {
		// TODO Auto-generated method stub
		return service.loginUser(u);
	}

	public String resetPassword(String email,String newPass) {
		// TODO Auto-generated method stub
	
		return service.resetPassword(email,newPass);

	}

	
	
	
}
