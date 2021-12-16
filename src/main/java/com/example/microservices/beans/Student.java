package com.example.microservices.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Students")
public class Student {
	
	public Student() {
		
	}
	
	public Student(int id, String name, String rollNo, String gender, String className,int subjectOne, int subjectTwo, int subjectThree, int total) {
		super();
		this.id = id;
		this.name = name;
		this.rollNo = rollNo;
		this.gender = gender;
		this.className = className;
		this.subjectOne = subjectOne;
		this.subjectTwo = subjectTwo;
		this.subjectThree = subjectThree;
		this.total = total;
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
	
	@Column(name = "sub1")
	int subjectOne;
	
	@Column(name = "sub2")
	int subjectTwo;
	
	@Column(name = "sub3")
	int subjectThree;
	
	@Column(name = "total")
	int total;
	
	
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

	public int getSubjectOne() {
		return subjectOne;
	}

	public void setSubjectOne(int subjectOne) {
		this.subjectOne = subjectOne;
	}

	public int getSubjectTwo() {
		return subjectTwo;
	}

	public void setSubjectTwo(int subjectTwo) {
		this.subjectTwo = subjectTwo;
	}

	public int getSubjectThree() {
		return subjectThree;
	}

	public void setSubjectThree(int subjectThree) {
		this.subjectThree = subjectThree;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	
	
	
	
	
	
	

}
