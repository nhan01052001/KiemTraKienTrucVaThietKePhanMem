package com.example.MentorService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.MentorService.entity.Mentor;

@Service
public interface MentorService {
	Mentor getOne(String mentorId);
	List<Mentor> getAll();
	Mentor add(Mentor mentor);
}
