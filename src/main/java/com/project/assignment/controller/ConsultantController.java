package com.project.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.assignment.entity.Consultant;
import com.project.assignment.service.ConsultantService;

@RestController
@RequestMapping("/api/consultants")
public class ConsultantController {

	private final ConsultantService consultantService;

	@Autowired
	public ConsultantController(ConsultantService consultantService) {
		this.consultantService = consultantService;
	}

	@GetMapping
	public ResponseEntity<List<Consultant>> searchConsultants(@RequestParam(required = false) String areaOfExpertise,
			@RequestParam(required = false) Integer experience) {
		List<Consultant> consultants = consultantService.searchConsultants(areaOfExpertise, experience);
		return new ResponseEntity<>(consultants, HttpStatus.OK);
	}
}
