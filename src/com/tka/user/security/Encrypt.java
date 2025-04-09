package com.tka.user.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypt {

  public static  String encryptMyPass(String pass)
	
	{
	  try {
          MessageDigest md = MessageDigest.getInstance("MD5");
          md.update(pass.getBytes());

          byte[] digest = md.digest();

          // Convert byte array into hexadecimal format
          StringBuilder hexString = new StringBuilder();
          for (byte b : digest) {
              String hex = Integer.toHexString(0xff & b);
              if (hex.length() == 1) hexString.append('0');
              hexString.append(hex);
          }

          return hexString.toString();

      } catch (NoSuchAlgorithmException e) {
          throw new RuntimeException("Error occurred while hashing password", e);
      }
		
	  
		
		
		
		
		
		
	}
	
	
}


