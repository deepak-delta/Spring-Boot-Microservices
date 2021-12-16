package com.example.microservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.beans.Student;
import com.example.microservices.services.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	
	
	
	@GetMapping("/api/students")
	public List<Student> getAllStudents()
	{
		return studentService.getAllStudents();
	}
	
	
	@PostMapping("/api/addstudent")
	public Student addStudent(@RequestBody Student student)
	{
		return studentService.addStudent(student);
	}
	
	
	
	@GetMapping("/api/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable(value = "id")int id)
	{
		try {
			Student student = studentService.getStudentById(id);
			return new ResponseEntity<Student>(student,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/api/students/findbyname")
	public ResponseEntity<Student> getStudentByName(@RequestParam(value = "name")String studentName)
	{
		try {
			Student student = studentService.getStudentByName(studentName);
			return new ResponseEntity<Student>(student,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
		}
	}
	
	@GetMapping("/api/students/findbyrollno")
	public ResponseEntity<Student> getStudentByRollNo(@RequestParam(value = "rollno")String studentRollNo)
	{
		try {
			Student student = studentService.getStudentByRollNo(studentRollNo);
			return new ResponseEntity<Student>(student,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
		}
	}
	
	
	
	@PutMapping("/api/students/edit/{id}")
	public ResponseEntity<Student> editStudent(@PathVariable(value = "id")int id ,@RequestBody Student student)
	{
		try {
			Student editStudent = studentService.getStudentById(id);
			editStudent.setName(student.getName());
			editStudent.setRollNo(student.getRollNo());
			editStudent.setGender(student.getGender());
			editStudent.setClassName(student.getClassName());
			
			Student editedStudent = studentService.editStudent(editStudent);
			return new ResponseEntity<Student>( editedStudent,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);	
		}
	}
	
	
	@DeleteMapping("/api/students/delete/{id}")
	public SendResponse deleteStudent(@PathVariable(value = "id")int id)
	{
		return studentService.deleteStudent(id);
		
	}
	
	
	@GetMapping("/api/students/sortandfilter")
	public List<Student> sortStudents(@RequestParam(value = "sortBy")String sortBy,@RequestParam(value = "sortType")String sortType,@RequestParam(value = "gender")String gender)
	{
		return studentService.sortStudents(sortBy,sortType,gender);
	}
	

}
