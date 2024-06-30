package com.tn.saasProjectTicket.serviceImpl;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailTicketServiceImpl {

	@Autowired
	private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;
    
	public void sendMAil(String to, String subject , String title , String message ) {
		try {			
			MimeMessage mimeMessage = mailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
	        helper.setFrom("benhouria097@outlook.com");
	        helper.setTo(to);
	        helper.setSubject(subject);

	        Context context = new Context();
	        context.setVariable("title", title);
	        context.setVariable("message", message);
	        String emailContent = templateEngine.process("email-template", context);

	        helper.setText(emailContent, true);

	        mailSender.send(mimeMessage);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public void sendMAilPassword(String to, String subject , String username , String password ) {
		try {			
			MimeMessage mimeMessage = mailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
	        helper.setFrom("benhouria097@outlook.com");
	        helper.setTo(to);
	        helper.setSubject(subject);

	        Context context = new Context();
	        context.setVariable("username", username);
	        context.setVariable("password", password);
	        String emailContent = templateEngine.process("email-template", context);

	        helper.setText(emailContent, true);

	        mailSender.send(mimeMessage);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
