package com.waffle.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.waffle.dto.JobDto;
import com.waffle.entity.WaffleJob;
import com.waffle.service.JobService;

@CrossOrigin(origins = "http://localhost:3000")	// temp for test
@RestController
@RequestMapping("/job")
public class JobController {

	@Autowired
	private JobService jobService;
	
	@PostMapping
	public void add(@RequestBody JobDto jobDto) {
		WaffleJob job = new WaffleJob();
		job.name = jobDto.getName() + new Date().getTime();
		jobService.addJob(job);
	}
	
	@GetMapping
	public List<WaffleJob> list() {
		return jobService.list();
	}
	
	@DeleteMapping
	public void delete(@RequestParam int[] jobId) {
		jobService.delete(jobId);
	}
}
