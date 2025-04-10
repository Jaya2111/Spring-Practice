package com.lvu2code.demo.rest;

import com.lvu2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct
    public void loadData()
    {
        theStudents=new ArrayList<>();
        theStudents.add(new Student("jayanth","Grandhe"));
        theStudents.add(new Student("jay","G"));
        theStudents.add(new Student("Mary","Rossi"));
    }
    @GetMapping("/students/{studentid}")
    public Student getStudents(@PathVariable  int studentid){
        if((studentid >=theStudents.size())||(studentid<0))
        {
            throw new StudentNotFoundExcepetion("Student id not found - "+studentid);
        }
        return theStudents.get(studentid);
    }
    // Add an exception handler using @ExceptionHandler

}
