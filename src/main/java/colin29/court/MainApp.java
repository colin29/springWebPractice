package colin29.court;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml", "beans2.xml");

		// Acquire Beans
		// HelloWorld obj = (HelloWorld) context.getBean("helloWorld");

	}

}
