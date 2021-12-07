package com.example.microservices.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
	
	public Student() {
		
	}
	
	public Student(int id, String name, String rollNo, String gender, String className) {
		super();
		this.id = id;
		this.name = name;
		this.rollNo = rollNo;
		this.gender = gender;
		this.className = className;
	}
	
	@Id
	@Column(name = "id")
	int id;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "rollno")
	String rollNo;
	
	@Column(name = "gender")
	String gender;
	
	@Column(name = "classname")
	String className;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	
	
	

}
