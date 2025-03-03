package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private field for the dependency

    private Coach mycoach;

    @Autowired
    public void SetCoach(Coach theCoach)   //setter injection
    {
        mycoach=theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkOut(){
        return mycoach.getDailyWorkout();
    }

}
