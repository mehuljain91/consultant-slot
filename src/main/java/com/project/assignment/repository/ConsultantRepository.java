package com.project.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.assignment.entity.Consultant;

@Repository
public interface ConsultantRepository extends JpaRepository<Consultant, Long> {
	
	List<Consultant> findByAreaOfExpertiseAndExperience(String areaOfExpertise, Integer experience);
	
	List<Consultant> findByAreaOfExpertise(String areaOfExpertise);

    List<Consultant> findByExperience(Integer experience);
}
