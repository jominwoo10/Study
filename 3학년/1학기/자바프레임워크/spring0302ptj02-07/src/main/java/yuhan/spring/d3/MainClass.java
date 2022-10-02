package yuhan.spring.d3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		String config = "classpath:application.xml";
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(config);
		Brand brand = ctx.getBean("brand",Brand.class);
		
		brand.like();
		ctx.close();

	}

}
