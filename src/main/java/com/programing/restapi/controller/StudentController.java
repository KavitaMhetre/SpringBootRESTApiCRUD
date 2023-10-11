package com.programing.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.programing.restapi.entity.Student;
import com.programing.restapi.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository repo;
	
	//get all the student
	//localhost:8080/students
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		List<Student> students =repo.findAll();
		return students;
	}
	
	//localhost:8080/students/1
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id) {
		
		Student student = repo.findById(id).get();
		return student;
		
	}
	
	//localhost:8080/students/add
	@PostMapping("/students/add")
	public void createStudent(@RequestBody Student student) {
		repo.save(student);
	}
	
	//localhost:8080/students/update/1
	@PutMapping("/students/update/{id}")
	public Student updateStudent(@PathVariable int id) {
		Student student = repo.findById(id).get();
		student.setName("poonam");
		student.setPercentage(92);
		repo.save(student);
		return student;
		
	}
	
	//localhost:8080/student/delete/1
	@DeleteMapping("/student/delete/{id}")
	public void removeStudent(@PathVariable int id ) {
		Student student = repo.findById(id).get();
		repo.delete(student);
	}

}
