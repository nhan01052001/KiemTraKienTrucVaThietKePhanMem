package com.example.StudentService.controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentService.dto.StudentDto;
import com.example.StudentService.entity.Student;
import com.example.StudentService.service.StudentService;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		return studentService.save(student);
	}
	@GetMapping("/students")
	public List<Student> getAll(){
		return studentService.getAll();
	}
	
	int count = 1;
	@GetMapping("students/{studentId}")
//	@Retry(name = "mentor")
//	@CircuitBreaker(name = "mentor")
	@RateLimiter(name = "mentor")
	public StudentDto getOne(@PathVariable String studentId) {
		try {
	        System.out.println(Thread.currentThread().getName() + "...running  " +
	                LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
	        
	    } catch (Exception e){
	        System.out.println(e.getLocalizedMessage());
	    }
					
		return studentService.getOne(studentId);
	}
}
