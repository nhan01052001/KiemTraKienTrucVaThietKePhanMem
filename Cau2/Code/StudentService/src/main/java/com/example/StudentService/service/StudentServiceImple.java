package com.example.StudentService.service;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.StudentService.dto.MentorDto;
import com.example.StudentService.dto.StudentDto;
import com.example.StudentService.entity.Student;
import com.example.StudentService.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImple implements StudentService {

	@Autowired
	private StudentRepository repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Student save(Student student) {
		// TODO Auto-generated method stub
		return repo.save(student);
	}
	
	@Override
	public StudentDto getOne(String studentId) {
		// TODO Auto-generated method stub
		HttpHeaders headers = new HttpHeaders();
		
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		Student student = repo.findById(studentId).get();
//		bill sang billdto
		String mentorId = student.getMentorId();
		MentorDto mentorDto = restTemplate.exchange("http://localhost:4001/mentors".concat("/").concat(mentorId), 
				 HttpMethod.GET, 
				 entity, 
				 MentorDto.class
				).getBody();
		StudentDto studentDto = StudentDto.builder()
			.studentId(student.getStudentId())
			.name(student.getName())
			.age(student.getAge())
			.mentor(mentorDto).build();

		return studentDto;
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}


}
