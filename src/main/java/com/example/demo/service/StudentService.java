package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.StudentDto;

public interface StudentService {
	
	/**
	 * find all students
	 * @return List of StudentDto
	 */
	 List<StudentDto> getAllStudent();
	 
	 /**
	  * Create new Student
	  * 
	  * @param newStudentDto
	  * @return new StudentDto
	  */
	 StudentDto createNewStudent(StudentDto newStudentDto);
	
}
