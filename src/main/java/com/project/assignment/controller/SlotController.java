package com.project.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.assignment.entity.Slot;
import com.project.assignment.service.SlotService;

@RestController
@RequestMapping("/api/slots")
public class SlotController {

	private final SlotService slotService;

    @Autowired
    public SlotController(SlotService slotService) {
        this.slotService = slotService;
    }

    @PostMapping("/create")
    public ResponseEntity<Slot> createSlot(@RequestBody Slot slot) {
        // Check if the user's role is consultant
        if (!"consultant".equals(slot.getRole())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        
        // Check if the consultant exists with the provided ID
        if (!slotService.doesConsultantExist(slot.getConsultantId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Slot createdSlot = slotService.createSlot(slot);
        return new ResponseEntity<>(createdSlot, HttpStatus.CREATED);
    }

    @GetMapping("/allslots")
    public ResponseEntity<List<Slot>> getAllSlots() {
        List<Slot> slots = slotService.getAllSlots();
        return new ResponseEntity<>(slots, HttpStatus.OK);
    }
}
