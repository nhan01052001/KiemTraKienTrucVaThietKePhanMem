package com.example.MentorService.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MentorService.entity.Mentor;
import com.example.MentorService.repository.MentorRepository;

@Service
@Transactional
public class MentorServiceImpl implements MentorService {

	@Autowired
	private MentorRepository repo;
	
	@Override
	public Mentor getOne(String mentorId) {
		// TODO Auto-generated method stub
		return repo.findById(mentorId).get();
	}

	@Override
	public List<Mentor> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Mentor add(Mentor mentor) {
		// TODO Auto-generated method stub
		return repo.save(mentor);
	}

}
