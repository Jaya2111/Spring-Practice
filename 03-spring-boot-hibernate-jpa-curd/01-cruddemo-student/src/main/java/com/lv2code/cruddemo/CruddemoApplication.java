package com.lv2code.cruddemo;

import com.lv2code.cruddemo.dao.StudentDAO;
import com.lv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);


	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
		return runner -> {
			//createStudent(studentDAO);
			 createMultipleStudent(studentDAO);
			//readStudent(studentDAO);
			//updateStudent(studentDAO);
			//deletestudent(studentDAO);
			//deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDAO studentDAO) {
		int k= studentDAO.deleteAll();
		System.out.println(k +" deleted");
	}

	private void deletestudent(StudentDAO studentDAO) {
		Student mystudent=studentDAO.findById(1);

		studentDAO.delete(2);
		Student mystudent1=studentDAO.findById(2);
		if(mystudent1==null)
		{
			System.out.println("Deleted ");
		}
		else
		{
			System.out.println("Not Deleted");
		}

	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId=1;
		System.out.println("Getting student with id: "+studentId);
		Student mystudent=studentDAO.findById(studentId);
		System.out.println(" student "+ mystudent);
		mystudent.setFirstname("Scooby");
		studentDAO.update(mystudent);
		System.out.println("updated student "+ mystudent);
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println(studentDAO.findById(2));
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		Student tempStudent =new Student("Jayanth","Grandhe","jayanth@luv2code.com");
		Student tempStudent1 =new Student("John","Doe","JohnDoe@luv2code.com");
		Student tempStudent2 =new Student("Mary","Public","MaryPublic@luv2code.com");
		studentDAO.save(tempStudent);
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);



	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student object...");
		Student tempStudent =new Student("Paul","Doe","Paul@luv2code.com");
		//save the student object
		System.out.println("Saving the student..");
		studentDAO.save(tempStudent);
		System.out.println("Saved Student. Generated id: "+ tempStudent.getId());
		//display id of the saved students
	}

}
