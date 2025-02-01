package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.BaseballCoach;
import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private field for the dependency

    private Coach mycoach;

//    @Autowired
//    public DemoController(@Qualifier("baseballCoach") Coach theCoach)   //Qualifier injection
//    {
//        mycoach=theCoach;
//    }
        @Autowired
    public DemoController( @Qualifier("cricketCoach") Coach theCoach)   //Primary
   {
       System.out.println("In constructor: "+ getClass().getSimpleName());

       mycoach=theCoach;
   }


    @GetMapping("/dailyworkout")
    public String getDailyWorkOut(){
        return mycoach.getDailyWorkout();
    }

}
