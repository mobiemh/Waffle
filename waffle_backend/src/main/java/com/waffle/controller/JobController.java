package com.waffle.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.waffle.entity.WaffleJob;
import com.waffle.service.JobService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/job")
public class JobController {

	@Autowired
	private JobService jobService;
	
	@PostMapping
	public void add(@RequestBody String name) {
		WaffleJob job = new WaffleJob();
		job.name = name + new Date().getTime();
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
