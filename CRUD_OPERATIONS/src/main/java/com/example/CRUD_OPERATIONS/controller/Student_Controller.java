package com.example.CRUD_OPERATIONS.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CRUD_OPERATIONS.entity.Student;
import com.example.CRUD_OPERATIONS.repo.StudentRepo;

@RestController
public class Student_Controller {
	
	@Autowired
	StudentRepo studentRepo;
	
	//For inserting the data into the database

	@PostMapping("/api/students")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		return new ResponseEntity<> (studentRepo.save(student),HttpStatus.CREATED);
	}
	
	
	//Displays all students or records from the selected table
	
	@GetMapping("/api/students")
	public ResponseEntity<List<Student>> getStudents()
	{
		return new ResponseEntity<> (studentRepo.findAll(), HttpStatus.OK);
	}
	
	
	
	//Getting single record or student by id
	
	@GetMapping("/api/students/{iD}")
	public ResponseEntity<Student> getStudent(@PathVariable long iD)
	{
		Optional<Student> student = studentRepo.findById(iD);
		if(student.isPresent())
		{ 
			return new ResponseEntity<> (student.get(), HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
	}
	
	
	//Updating the existing records 
	
	@PutMapping("/api/students/{iD}")
	public ResponseEntity<Student> updateStudent(@PathVariable long iD, @RequestBody Student student1)
	{
		Optional<Student> student = studentRepo.findById(iD);
		if(student.isPresent())
		{ 
			
			student.get().setStudentName(student1.getStudentName());
			student.get().setStudentEmail(student1.getStudentEmail());
			student.get().setStudentAddress(student1.getStudentAddress());
			return new ResponseEntity<> (studentRepo.save(student.get()), HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@DeleteMapping("/api/students/{iD}")
	public ResponseEntity<Void> deleteStudent(@PathVariable long iD)
	{
		Optional<Student> student = studentRepo.findById(iD);
		if(student.isPresent())
		{ 
			studentRepo.deleteById(iD);
			return new ResponseEntity<> (HttpStatus.NO_CONTENT);
		}
		else
		{
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
	}

	
	
	
}
