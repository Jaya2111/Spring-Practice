package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImp1 implements  EmployeeDAO{
    //define field for entity manager
    private EntityManager entityManager;

@Autowired
    public EmployeeDAOJpaImp1(EntityManager theentitymanager)
    {
        entityManager=theentitymanager;
    }
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> thequery =entityManager.createQuery("from Employee",Employee.class);
        return thequery.getResultList();
    }
    public Employee findById(int theId)
    {
        return entityManager.find(Employee.class,theId);
    }

    @Override
    public Employee save(Employee theemp) {
        return entityManager.merge(theemp);
    }

    @Override
    public void deleteById(int theid) {
             Employee theemp=entityManager.find(Employee.class,theid);
             entityManager.remove(theemp);
    }
}
