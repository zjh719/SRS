package com.github.zjh.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.zjh.util.JavaEmail;
import com.github.zjh.util.MailUtil;
import com.github.zjh.util.SendEmail;

public class InitListener implements ServletContextListener {
	@Autowired
	protected JavaEmail sndEmail;
	
	@Override
	public void contextInitialized(ServletContextEvent paramServletContextEvent) {
//		System.out.println(paramServletContextEvent.getServletContext());
//		
		// TODO Auto-generated method stub
//		sndEmail.sendTextEmail("1009925846@qq.com", "测试", "hello");
//		System.out.println("邮件已发送");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
