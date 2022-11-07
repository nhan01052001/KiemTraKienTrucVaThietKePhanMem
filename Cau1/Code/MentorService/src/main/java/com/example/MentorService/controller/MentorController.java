package com.example.MentorService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MentorService.entity.Mentor;
import com.example.MentorService.service.MentorService;

@RestController
@RequestMapping("/mentors")
public class MentorController {
	
	@Autowired
	private MentorService mentorService;
	int count = 1;
	
	public List<Mentor> findAll() {
		System.out.println("- retry "+ (count++));
		
		return mentorService.getAll();
	}
	
	@GetMapping("/{mentorId}")
	public Mentor getMentor(@PathVariable String mentorId) {
		System.out.println(mentorId);
		return mentorService.getOne(mentorId);
	}
	
	@PostMapping()
	public Mentor save(@RequestBody Mentor mentor) {
		return mentorService.add(mentor);
	}
}
