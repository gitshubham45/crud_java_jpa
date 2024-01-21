package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.List;


@ComponentScan
@SpringBootApplication
@Component
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner->{
//			createStudent(studentDAO);

//			createMultipleStudents(studentDAO);

//			readStudent(studentDAO);

//			queryForStudent(studentDAO);

//			queryForStudentByLastName(studentDAO);

			updateStudent(studentDAO);

		};

	}

	private void updateStudent(StudentDAO studentDAO){
		// retrieve student based on the id: primary key
		int studentId = 3000;
		System.out.println("Getting student with id:" + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first Name to scooby
		System.out.println("Updating student...");
		myStudent.setFirstName("Stuart");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student" + myStudent);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("doe");

		// display the list of students
		for(Student tempStudent:theStudents){
			System.out.println(tempStudent);
		}

	}


	private void queryForStudent(StudentDAO studentDAO){

		// get a list of students
		List<Student> theStudents = studentDAO.findAll();
		// display list of students
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO){
		// create a student object
		System.out.println("Creating new student object..");
		Student tempStudent = new Student("Ray","Johnson","ray@abc.com");
		// save the student
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: "+ theId);

		// retrieve student based on id: primary key
		System.out.println("Retrieving student with id: "+ theId);
		Student myStudent = studentDAO.findById(theId);

		//display student
		System.out.println("Found the Student: "+ myStudent);
	}

	// create multiple students
	private void createMultipleStudents(StudentDAO studentDAO){
		System.out.println("Creating multiple student object..");
		Student tempStudent1 = new Student("John","Doe","john@doe.com");
		Student tempStudent2 = new Student("Ross","Doe","Ross@doe.com");
		Student tempStudent3 = new Student("Peter","Doe","Peter@doe.com");
		Student tempStudent4 = new Student("Sam","Doe","sam@doe.com");

		System.out.println("Saving students..");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		studentDAO.save(tempStudent4);

	}
	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student object..");
		Student tempStudent = new Student("Paul","Doe","paul@doe.com");

		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: "+ tempStudent.getId());
		System.out.println(tempStudent.toString());
	}
}
