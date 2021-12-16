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
	
	
	public Student addStudent(Student student)
	{
		student.setId(getMaxId());
		int totalTemp = student.getSubjectOne()+student.getSubjectTwo()+student.getSubjectThree();
		student.setTotal(totalTemp);
		studentRepository.save(student);
		return student;
		
	}
	
	
	
	public List<Student> sortStudents(String sortBy,String sortType,String gender)
	{
		List<Student> students2 = new ArrayList<>();
		
		switch (sortType) {
		case "asc": {
			switch (sortBy) {
			case "name": {
				List<Student> students = studentRepository.findAll(Sort.by("name"));
				for (Student student : students) 
				{
					if(student.getGender().equalsIgnoreCase(gender))
						students2.add(student);	
				}
				return students2;	
			
			}
			
			case "subjectOne": {
				List<Student> students = studentRepository.findAll(Sort.by("subjectOne"));
				for (Student student : students) 
				{
					if(student.getGender().equalsIgnoreCase(gender))
						students2.add(student);	
				}
				return students2;	
			
			}
			case "subjectTwo": {
				List<Student> students = studentRepository.findAll(Sort.by("subjectTwo"));
				for (Student student : students) 
				{
					if(student.getGender().equalsIgnoreCase(gender))
						students2.add(student);	
				}
				return students2;	
			
			}
			case "subjectThree": {
				List<Student> students = studentRepository.findAll(Sort.by("subjectThree"));
				for (Student student : students) 
				{
					if(student.getGender().equalsIgnoreCase(gender))
						students2.add(student);	
				}
				return students2;	
			
			}
			case "total": {
				List<Student> students = studentRepository.findAll(Sort.by("total"));
				for (Student student : students) 
				{
					if(student.getGender().equalsIgnoreCase(gender))
						students2.add(student);	
				}
				return students2;	
			
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + sortBy);
			}
			
		}
		case "dec": {
			switch (sortBy) {
			case "name": {
				List<Student> students = studentRepository.findAll(Sort.by("name").descending());
				for (Student student : students) 
				{
					if(student.getGender().equalsIgnoreCase(gender))
						students2.add(student);	
				}
				return students2;	
			}
			case "subjectOne": {
				List<Student> students = studentRepository.findAll(Sort.by("subjectOne").descending());
				for (Student student : students) 
				{
					if(student.getGender().equalsIgnoreCase(gender))
						students2.add(student);	
				}
				return students2;	
			
			}
			case "subjectTwo": {
				List<Student> students = studentRepository.findAll(Sort.by("subjectTwo").descending());
				for (Student student : students) 
				{
					if(student.getGender().equalsIgnoreCase(gender))
						students2.add(student);	
				}
				return students2;	
			
			}
			case "subjectThree": {
				List<Student> students = studentRepository.findAll(Sort.by("subjectThree").descending());
				for (Student student : students) 
				{
					if(student.getGender().equalsIgnoreCase(gender))
						students2.add(student);	
				}
				return students2;	
			
			}
			case "total": {
				List<Student> students = studentRepository.findAll(Sort.by("total").descending());
				for (Student student : students) 
				{
					if(student.getGender().equalsIgnoreCase(gender))
						students2.add(student);	
				}
				return students2;	
			
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + sortBy);
			}
			
		}
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + sortType);
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




