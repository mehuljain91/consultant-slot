package com.project.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.assignment.entity.Slot;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {
	
	List<Slot> findByConsultantId(Long consultantId);
}
