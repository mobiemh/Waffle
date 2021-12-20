package com.waffle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.waffle.entity.WaffleJob;

@Repository
public interface WaffleJobRepository extends JpaRepository<WaffleJob, Integer> {
	
}
