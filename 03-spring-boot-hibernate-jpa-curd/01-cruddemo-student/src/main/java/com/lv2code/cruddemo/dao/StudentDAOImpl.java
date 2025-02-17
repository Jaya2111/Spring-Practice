package com.lv2code.cruddemo.dao;

import com.lv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO{



    //define field for entity manager
    private EntityManager entityManager;
    //inject entity manager using construtor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    //implement save method

    @Override
    @Transactional
    public void save(Student theStudent) {
            entityManager.persist(theStudent);

    }

    @Override
    public Student findById(Integer i) {
        return entityManager.find(Student.class,i);
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }




    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStudent=entityManager.find(Student.class, id);
        entityManager.remove(theStudent);
   }
//    public void delete(Student theStudent) {
//        entityManager.remove(entityManager.merge(theStudent));
//    }
@Override
@Transactional
public int deleteAll()
{
    int numrowsdeleted=entityManager.createQuery("Delete From Student").executeUpdate();
    return numrowsdeleted;
}


}
