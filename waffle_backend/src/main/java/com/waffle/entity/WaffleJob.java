package com.waffle.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WaffleJob {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int jobId;
	public String name;
	public Date alertStartDate;
	public Date alertEndDate;
}
