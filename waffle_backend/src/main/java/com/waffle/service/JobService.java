package com.waffle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waffle.entity.WaffleJob;
import com.waffle.repository.WaffleJobRepository;

import lombok.RequiredArgsConstructor;

@Service
public class JobService {
	
	@Autowired
	private WaffleJobRepository waffleJobRepository;
	
	public void addJob(WaffleJob entity) {
		waffleJobRepository.saveAndFlush(entity);
	}

	public List<WaffleJob> list() {
		return waffleJobRepository.findAll();
	}

	public void delete(int[] jobId) {
	}
}
