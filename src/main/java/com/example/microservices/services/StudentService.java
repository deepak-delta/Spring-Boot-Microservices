package com.example.microservices.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.microservices.beans.Student;
import com.example.microservices.controllers.SendResponse;
import com.example.microservices.repositories.StudentRepository;

import java.util.*;


@Component
@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> getAllStudents()
	{
		return studentRepository.findAll();
	}
	
	public List<Student> sortStudents(String type,String gender)
	{
		List<Student> students2 = new ArrayList<>();
		
		switch (type) {
		case "asc": {
			List<Student> students = studentRepository.findAll(Sort.by("name"));
			for (Student student : students) 
			{
				if(student.getGender().equalsIgnoreCase(gender))
					students2.add(student);	
			}
			return students2;	
		}
		case "des": {
			
			List<Student> students = studentRepository.findAll(Sort.by("name").descending());
			for (Student student : students) 
			{
				if(student.getGender().equalsIgnoreCase(gender))
					students2.add(student);	
			}
			return students2;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + type);
		}	
		
		
		
	}
	
	public Student getStudentById(int id)
	{
		return studentRepository.findById(id).get();
	}
	
	public Student getStudentByName(String studentName)
	{
		List<Student> students = studentRepository.findAll();
		Student studentData = null;
		
		for (Student student : students) 
		{
			if(student.getName().equalsIgnoreCase(studentName))
				studentData = student;
				
		}
		return studentData;
	}
	
	
	public Student getStudentByRollNo(String studentRollNo)
	{
		List<Student> students = studentRepository.findAll();
		Student studentData = null;
		
		for (Student student : students) 
		{
			if(student.getRollNo().equalsIgnoreCase(studentRollNo))
				studentData = student;
	
		}
		return studentData;
	}
	
	public Student addStudent(Student student)
	{
		student.setId(getMaxId());
		studentRepository.save(student);
		return student;
		
	}
	
	
	public int getMaxId()
	{
		return studentRepository.findAll().size()+1;
	}
	
	public Student editStudent(Student student)
	{
		studentRepository.save(student);
		return student;
	}
	
	
	public SendResponse deleteStudent(int id)
	{
		studentRepository.deleteById(id);
		
		SendResponse response = new SendResponse();
		response.setMsg("Student details deleted");
		response.setId(id);
		return response;
	}	
}




