package com.project.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.assignment.entity.Consultant;
import com.project.assignment.entity.Slot;
import com.project.assignment.repository.ConsultantRepository;
import com.project.assignment.repository.SlotRepository;

@RestController
public class SearchController {

	@Autowired
	private ConsultantRepository consultantRepository;

	@Autowired
	private SlotRepository slotRepository;

	@GetMapping("/search")
	public List<Consultant> searchConsultants(@RequestParam String areaOfExpertise, @RequestParam int experience) {
		return consultantRepository.findByAreaOfExpertiseAndExperience(areaOfExpertise, experience);
	}

	@GetMapping("/consultant/slots")
	public List<Slot> getConsultantSlots(@RequestParam Long consultantId) {
		return slotRepository.findByConsultantId(consultantId);
	}
}
