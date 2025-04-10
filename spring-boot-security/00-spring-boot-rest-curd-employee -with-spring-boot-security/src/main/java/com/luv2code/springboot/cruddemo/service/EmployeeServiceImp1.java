package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp1 implements EmployeeService{


    private EmployeeRepository employeeRepository;

    public EmployeeServiceImp1(EmployeeRepository emp)
    {
        employeeRepository=emp;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result=employeeRepository.findById(id);
        Employee emp=null;
        if(result.isPresent())
        {
            emp=result.get();
        }
        else {
            throw  new RuntimeException("Did not find employee id -"+id);
        }
        return emp;
    }
    //@Transactional
    @Override
    public Employee save(Employee theemp) {
        return employeeRepository.save(theemp);
    }
//Transactional
    @Override
    public void deleteById(int theid) {
    employeeRepository.deleteById(theid);
    }

}
