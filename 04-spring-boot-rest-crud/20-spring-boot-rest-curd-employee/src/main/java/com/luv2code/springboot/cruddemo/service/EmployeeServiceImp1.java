package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImp1 implements EmployeeService{


    private EmployeeDAO employeeDAO;

    public EmployeeServiceImp1(EmployeeDAO emp)
    {
        employeeDAO=emp;
    }
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }
    @Transactional
    @Override
    public Employee save(Employee theemp) {
        return employeeDAO.save(theemp);
    }
@Transactional
    @Override
    public void deleteById(int theid) {
employeeDAO.deleteById(theid);
    }

}
