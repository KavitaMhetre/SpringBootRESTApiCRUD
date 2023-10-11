package com.programing.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.programing.restapi.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	
}
