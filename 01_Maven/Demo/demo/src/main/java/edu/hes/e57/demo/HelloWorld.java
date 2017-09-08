package edu.hes.e57.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.hes.e57.demo.providers.MessageRenderer;

public class HelloWorld {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext
           ("META-INF/spring/app-context.xml");

        MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();
    }
}

