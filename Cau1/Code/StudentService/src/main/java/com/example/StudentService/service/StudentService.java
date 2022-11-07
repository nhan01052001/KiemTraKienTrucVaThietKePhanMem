package com.example.StudentService.service;

import java.util.List;

import com.example.StudentService.dto.StudentDto;
import com.example.StudentService.entity.Student;

public interface StudentService {
	Student save(Student student);
	StudentDto getOne(String studentId);
	List<Student> getAll();
}
