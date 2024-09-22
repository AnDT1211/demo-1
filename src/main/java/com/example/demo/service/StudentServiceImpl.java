package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<StudentDto> getAllStudent() {
		return studentRepository.findAll().stream().map(x -> new StudentDto(x.getId(), x.getName(), x.getAddress()))
				.toList();
	}

	public StudentDto createNewStudent(StudentDto newStudentDto) {
		System.out.println(newStudentDto);
		Student s = studentRepository.save(new Student() {
			{
				setName(newStudentDto.getName());
				setAddress(newStudentDto.getAddress());
			}

		});
		return new StudentDto(s.getId(), s.getName(), s.getAddress());
	}
}
