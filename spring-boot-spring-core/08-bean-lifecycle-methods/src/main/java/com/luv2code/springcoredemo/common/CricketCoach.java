package com.luv2code.springcoredemo.common;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Primary
public class CricketCoach implements Coach {
    public CricketCoach()
    {
        System.out.println("In constructor: "+ getClass().getSimpleName());

    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 20 minutes!!!";
    }
}
