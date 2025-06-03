package com.e_commerce.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
    @Autowired
	private JavaMailSender javaMailSender;
    
    public void sendEmail(String toEmail,String subject,String body){
    	
    	
    	try {
    		MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        	MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,"utf-8");
			mimeMessageHelper.setFrom("rgsilikat@gmail.com");
			mimeMessageHelper.setTo(toEmail);
	    	mimeMessageHelper.setText(body,true);
	    	mimeMessageHelper.setSubject(subject);
	    	javaMailSender.send(mimeMessage);
		} catch (MessagingException e) {
			 e.printStackTrace();
		}
    	
    }
 }
