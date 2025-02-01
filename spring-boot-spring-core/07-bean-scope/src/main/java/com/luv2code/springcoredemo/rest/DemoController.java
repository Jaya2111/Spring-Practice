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
    private Coach mycoach2;

//    @Autowired
//    public DemoController(@Qualifier("baseballCoach") Coach theCoach)   //Qualifier injection
//    {
//        mycoach=theCoach;
//    }
        @Autowired
    public DemoController( @Qualifier("cricketCoach") Coach theCoach,@Qualifier("cricketCoach") Coach theCoach2)   //Primary
   {
       System.out.println("In constructor: "+ getClass().getSimpleName());

       mycoach=theCoach;
       mycoach2=theCoach2;
   }
@GetMapping("/check")
public String check()
{
    return "Check bean scope " + (mycoach2==mycoach);
}

    @GetMapping("/dailyworkout")
    public String getDailyWorkOut(){
        return mycoach.getDailyWorkout();
    }

}
