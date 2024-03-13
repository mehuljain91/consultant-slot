package com.project.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.assignment.entity.Consultant;
import com.project.assignment.repository.ConsultantRepository;

@Service
public class ConsultantService {

	private final ConsultantRepository consultantRepository;

	@Autowired
	public ConsultantService(ConsultantRepository consultantRepository) {
		this.consultantRepository = consultantRepository;
	}

	public List<Consultant> searchConsultants(String areaOfExpertise, Integer experience) {
		if (areaOfExpertise != null && experience != null) {
			return consultantRepository.findByAreaOfExpertiseAndExperience(areaOfExpertise, experience);
		} else if (areaOfExpertise != null) {
			return consultantRepository.findByAreaOfExpertise(areaOfExpertise);
		} else if (experience != null) {
			return consultantRepository.findByExperience(experience);
		} else {
			return consultantRepository.findAll();
		}
	}
}
