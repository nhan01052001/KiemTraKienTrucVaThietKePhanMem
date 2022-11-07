package com.example.StudentService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter@Setter
public class Student {
	@Id
	@Column(name = "StudentId",columnDefinition = "varchar(9)")
	private String studentId;
	private String name;
	private int age;
	private String mentorId;
}
