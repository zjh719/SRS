package com.github.zjh.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.Resource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailUtil {
	 public static JavaMailSenderImpl mailSender = createMailSender(SpringEmailInfo.mail_host,SpringEmailInfo.mail_port,SpringEmailInfo.mail_username,
			 SpringEmailInfo.mail_password,SpringEmailInfo.mail_smtp_timeout);
	    public static String mailFrom = SpringEmailInfo.mail_from;
	    private static JavaMailSenderImpl createMailSender(String host,int port,String username,String password,int timeout){
	        JavaMailSenderImpl sender = new JavaMailSenderImpl();
	        sender.setHost(host);
	        sender.setPort(port);
	        sender.setUsername(username);
	        sender.setPassword(password);
	        sender.setDefaultEncoding("Utf-8");
	        Properties p = new Properties();
	        p.setProperty("mail.smtp.timeout",timeout+"");
	        p.setProperty("mail.smtp.auth","true");
	        sender.setJavaMailProperties(p);
	        return sender;
	    }
	    //发送测试的邮件
	    public static void sendMailForTest(String host,int port,String username,String password,String from,
	            String to){
	        SimpleMailMessage mail = new SimpleMailMessage();
	        mail.setFrom(from);
	        mail.setTo(to);
	        mail.setSubject("这是测试邮件，请勿回复！");
	        mail.setSentDate(new Date());// 邮件发送时间
	        mail.setText("这是一封测试邮件。如果您已收到此邮件，说明您的邮件服务器已设置成功。请勿回复，请勿回复，请勿回复，重要的事说三遍！");
	        JavaMailSenderImpl sender = createMailSender(host,port,username,password,25000);
	        sender.send(mail);
	    }
	    
	    public static void sendTextMail(String to,String subject,String text){
	        SimpleMailMessage mail = new SimpleMailMessage();
	        mail.setFrom(mailFrom);
	        mail.setTo(to);
	        mail.setSubject(subject);
	        mail.setSentDate(new Date());// 邮件发送时间
	        mail.setText(text);
	        mailSender.send(mail);
	    }
	    public static void sendHtmlMail(String to,String subject,String html) throws MessagingException {
	        MimeMessage mimeMessage = mailSender.createMimeMessage();
	        // 设置utf-8或GBK编码，否则邮件会有乱码
	        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
	        messageHelper.setFrom(mailFrom);
	        messageHelper.setTo(to);
	        messageHelper.setSubject(subject);
	        messageHelper.setText(html, true);
	        mailSender.send(mimeMessage);
	    }

	    public static void sendFileMail(String to,String subject,String html,String contentId,Resource resource) throws MessagingException {
	        MimeMessage mimeMessage = mailSender.createMimeMessage();
	        // 设置utf-8或GBK编码，否则邮件会有乱码
	        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
	        messageHelper.setFrom(mailFrom);
	        messageHelper.setTo(to);
	        messageHelper.setSubject(subject);
	        messageHelper.setText(html, true);
	        //FileSystemResource img = new FileSystemResource(new File("c:/350.jpg"));
	        messageHelper.addInline(contentId, resource);
	        // 发送
	        mailSender.send(mimeMessage);
	    }

}
