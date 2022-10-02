package yuhan.spring.di;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		GenericApplicationContext ctx = new GenericXmlApplicationContext("classpath:application.xml");
	 
		MyInfo myInfo = ctx.getBean("Info",MyInfo.class);
		myInfo.getInfo();
		
		ctx.close();
	}

}
