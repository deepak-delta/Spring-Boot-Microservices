package com.example.microservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microservices.beans.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
