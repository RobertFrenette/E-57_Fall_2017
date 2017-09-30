package edu.hes.e57.demo;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * This example is taken from Pro Spring 4: com.apress.prospring4.ch5
 *
 * mvn clean install
 * mvn exec:java -Dexec.mainClass="edu.hes.e57.demo.SpringAopAspectjExample" -Dexec.cleanupDaemonThreads=false
 * mvnDebug exec:java -Dexec.mainClass="edu.hes.e57.demo.SpringAopAspectjExample" -Dexec.cleanupDaemonThreads=false
 */
public class SpringAopAspectjExample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-xml.xml");
		ctx.refresh();

		UserManager manager = ctx.getBean(UserManager.class);

		User user1 = new User();
		user1.setId(1);
		user1.setUserName("FooBar");

		manager.addUser(user1);
		User emp = manager.getUserById(1);

		ctx.close();
	}
}