package com.luv2code.springboot.cruddemo.rest;


import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

//    private EmployeeDAO employeeDAO;
//public EmployeeRestController(){};
//
//@Autowired
//    public EmployeeRestController(EmployeeDAO theEmployee)
//    {
//        employeeDAO=theEmployee;
    //}

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService emp)
    {
        employeeService=emp;
    }


    @GetMapping("/employee")
    public List<Employee> findAll()
    {
        return employeeService.findAll();
    }
    @GetMapping("/employee/{id}")
    public Employee findById(@PathVariable int id)
    {
        Employee emp=employeeService.findById(id);
        if(emp==null)
        {
            throw new RuntimeException("Emploee id not found "+id);
        }
        return emp;
    }
    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee theEmployee)
    {
        theEmployee.setId(0);
        Employee emp=employeeService.save(theEmployee);
        return emp;
    }
    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable int id)
    {
        employeeService.deleteById(id);
    }
    @PutMapping("/employee")
    public  Employee updateEmployee(@RequestBody Employee theEmp)
    {
        Employee dbemp=employeeService.save(theEmp);
        return dbemp;
    }
}
