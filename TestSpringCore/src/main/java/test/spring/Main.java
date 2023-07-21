package test.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("services.xml");
		TestSpringService testSpring = (TestSpringService) context.getBean("testSpringService");
		testSpring.printClassName();
	}

}