package com.github.zjh.util;




import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;





/**
 * @author ZJH
 * @since Jdk1.8
 * @describe javaemai邮件发送工具
 * @time 2017年6月6日下午11:37:11
 */
@Component
public class JavaEmail {
	
	static final String NAME="xmuscxxems"; //发送人名称
	static final String FROM="xmuscxxems@vip.sina.com"; //发送人地址
	static final String PASSWORD="xmuems.123"; //发送人密码
	static final String HOST="smtp.vip.sina.com"; //发送人host
	static final String AUTH="true"; //是否需要验证
	static final String PROTOCOL="smtp"; //发送人host类型
	static final String MYNICK="lpfcumt"; //发送人昵称
	
	
	/**
	 * @method 发送HTML类型邮件
	 * @author ZJH
	 * @param to 收件人地址
	 * @param subject 主题
	 * @param content 内容
	 */
	public  void sendHtmlEmail(String to,String subject,String content){
			try{
				Properties props = new Properties();
				props.setProperty("mail.smtp.auth", AUTH);
				props.setProperty("mail.transport.protocol", PROTOCOL);
				props.setProperty("mail.smtp.host", HOST);
				Session session = Session.getInstance(props, new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(NAME, PASSWORD);
					}
				});
				session.setDebug(true);
				String nick="";  
			    try {  
			        nick=javax.mail.internet.MimeUtility.encodeText(MYNICK);  
			    } catch (UnsupportedEncodingException e) {  
			        e.printStackTrace();  
			    }   
				Message msg = new MimeMessage(session);
				msg.setFrom(new InternetAddress(FROM,nick));
				msg.setHeader("X-Mailer", "Microsoft Outlook Express 6.00.2900.2869");
				msg.setSubject(subject);
				
				msg.setRecipients(RecipientType.TO,
						InternetAddress.parse(to));
				msg.setContent(content,"text/html;charset=utf-8");
				Transport.send(msg);
			}catch (Exception e) {    
		        e.printStackTrace();    
		    }
	
	}

	
	/**
	 * @method 发送TEXT类型邮件
	 * @author ZJH
	 * @param to 收件人地址
	 * @param subject 主题
	 * @param text 内容
	 */
	public void sendTextEmail(String to,String subject,String text){
		try{
			Properties props = new Properties();
			props.setProperty("mail.smtp.auth", AUTH);
			props.setProperty("mail.transport.protocol", PROTOCOL);
			props.setProperty("mail.smtp.host", HOST);
			Session session = Session.getInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(NAME, PASSWORD);
				}
			});
			session.setDebug(true);
			String nick="";  
		    try {  
		        nick=javax.mail.internet.MimeUtility.encodeText(MYNICK);  
		    } catch (UnsupportedEncodingException e) {  
		        e.printStackTrace();  
		    }   
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(FROM,nick));
			msg.setHeader("X-Mailer", "Microsoft Outlook Express 6.00.2900.2869");
			msg.setSubject(subject);
			
			msg.setRecipients(RecipientType.TO,
					InternetAddress.parse(to));
			msg.setText(text);
			Transport.send(msg);
		}catch (Exception e) {    
	        e.printStackTrace();    
	    }
	}

}
