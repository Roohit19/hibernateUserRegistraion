package com.tka.user.utility;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;



public class MailSender {

	
	public static void sendEmail(String toEmail,String pass)
	{
		
		   final String fromEmail = "mungaserohit76@gmail.com"; // Your email
	        final String password = "qnel kqmo mkjv gnxy"; // Use an App Password

	        // SMTP properties
	        Properties props = new Properties();
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.socketFactory.port", "465");
	        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.port", "465");


	        // Session with authentication
	        Session session = Session.getDefaultInstance(props,
	        	    new javax.mail.Authenticator() {
	        	        protected PasswordAuthentication getPasswordAuthentication() {
	        	            return new PasswordAuthentication(fromEmail, password);
	        	        }
	        	    });

	        try {
	            // Creating email message
	        	Message message = new MimeMessage(session); // ✅ Correct
	            message.setFrom(new InternetAddress(fromEmail));
	            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
	            message.setSubject("Your OTP Code");
	            message.setText("Your password  is: " + pass);

	            // Send email
	            Transport.send(message);
	            System.out.println("✅ Email sent successfully to " + toEmail);
	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	    }
	
	
}
