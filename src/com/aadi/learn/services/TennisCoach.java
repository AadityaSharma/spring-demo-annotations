package com.aadi.learn.services;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
//@Scope("singleton")
public class TennisCoach implements Coach, InitializingBean, DisposableBean {

    @Qualifier("randomFortuneService")
    @Autowired
    private FortuneService fortuneService;

    /*
    @Autowired
    public TennisCoach(FortuneService fortuneService) {
        System.out.println(">> TennisCoach: inside custom constructor");
        this.fortuneService = fortuneService;
    } */

    // define a default constructor
    public TennisCoach() {
        System.out.println(">> TennisCoach: inside default constructor");
    }

    /*
    // example of setter injection
    @Autowired
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println(">> TennisCoach: inside setFortuneService() method");
        this.fortuneService = fortuneService;
    }

    // example of method injection
    @Autowired
    public void doSomeCrazyStuff(FortuneService fortuneService) {
        System.out.println(">> TennisCoach: inside doSomeCrazyStuff() method");
        this.fortuneService = fortuneService;
    }
    */

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    // this method will be executed after initialization of the bean
    // @PostConstruct
    // public void doMyStartupStuff() { }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(">> TennisCoach: inside of afterPropertiesSet() method");
    }

    // ths method will be executed after destroying the bean
    // @PreDestroy
    // public void doMyCleanupStuff() { }
    @Override
    public void destroy() throws Exception {
        System.out.println(">> TennisCoach: inside of destroy() method");
    }


}
