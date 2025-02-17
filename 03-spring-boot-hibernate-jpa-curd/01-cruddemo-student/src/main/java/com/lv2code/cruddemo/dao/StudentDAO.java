package com.lv2code.cruddemo.dao;

import com.lv2code.cruddemo.entity.Student;

public interface StudentDAO {
  void save(Student theStudent);
  Student findById(Integer i);
void update(Student theStudent);
//void delete(Student theStudent);
  void delete(Integer id);
  int deleteAll();
}
