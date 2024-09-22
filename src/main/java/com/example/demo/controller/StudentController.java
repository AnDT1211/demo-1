package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StudentDto;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping(("api/student"))
public class StudentController {
//	@Autowired
	StudentService studentService;
	
//	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	

	@GetMapping("get-all")
	ResponseEntity<List<StudentDto>> getAllStudent() {
		return ResponseEntity.ok(studentService.getAllStudent());
	}

	@PostMapping("create")
	ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
		return new ResponseEntity<StudentDto>(studentService.createNewStudent(studentDto), HttpStatus.CREATED);
	}

}
