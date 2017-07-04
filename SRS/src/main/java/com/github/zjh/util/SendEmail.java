package com.github.zjh.util;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

@Component
public class SendEmail {
	@Autowired
	protected MailUtil mailUtil;

		public void sendSimpleMail(){
			mailUtil.sendTextMail("1009925846@qq.com", "测试", "hello");
		}
}
