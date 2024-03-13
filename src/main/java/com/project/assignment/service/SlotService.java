package com.project.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.assignment.entity.Slot;
import com.project.assignment.repository.ConsultantRepository;
import com.project.assignment.repository.SlotRepository;

@Service
public class SlotService {

	private final SlotRepository slotRepository;
	private final ConsultantRepository consultantRepository;

	@Autowired
	public SlotService(SlotRepository slotRepository, ConsultantRepository consultantRepository) {
		this.slotRepository = slotRepository;
		this.consultantRepository = consultantRepository;
	}

	public Slot createSlot(Slot slot) {
		return slotRepository.save(slot);
	}

	public List<Slot> getAllSlots() {
		return slotRepository.findAll();
	}

	public boolean doesConsultantExist(Long consultantId) {
		return consultantRepository.existsById(consultantId);
	}

}
