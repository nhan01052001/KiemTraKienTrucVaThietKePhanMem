package com.example.StudentService.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {
	private String studentId;
	private String name;
	private int age;
	private MentorDto mentor;
}
