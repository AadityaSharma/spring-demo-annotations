package com.aadi.learn.main;

import com.aadi.learn.config.SportConfig;
import com.aadi.learn.services.Coach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

    public static void main(String[] args) {

        // load spring config file
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        // retrieve bean from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

        // check if they are the same
        boolean result = (theCoach == alphaCoach);

        // print out the results
        System.out.println("\nAre both the beans pointing to the same object? : " + result);
        System.out.println("\nMemory location for theCoach: " + theCoach);
        System.out.println("\nMemory location for alphaCoach: " + alphaCoach + "\n");

        // close the context
        context.close();
    }
}
