package com.fugf.app.mqtest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @描述: ActiveMQ测试启动类  .
 * @版本号: V1.0 .
 */
public class MQConsumer {
	private static final Log log = LogFactory.getLog(MQConsumer.class);

	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
			context.start();
		//	System.in.read();
		} catch (Exception e) {
			log.error("==>MQ context start error:", e);
			System.exit(0);
		}
	}
}
