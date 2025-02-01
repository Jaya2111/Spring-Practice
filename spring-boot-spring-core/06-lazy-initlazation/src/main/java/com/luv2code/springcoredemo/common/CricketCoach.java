package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
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
