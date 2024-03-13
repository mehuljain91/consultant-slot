package com.project.assignment.testing;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.assignment.controller.ConsultantController;
import com.project.assignment.controller.SlotController;
import com.project.assignment.controller.UserController;
import com.project.assignment.entity.Client;
import com.project.assignment.entity.Consultant;
import com.project.assignment.entity.Slot;
import com.project.assignment.entity.User;
import com.project.assignment.exceptions.ValidationException;
import com.project.assignment.service.ConsultantService;
import com.project.assignment.service.SlotService;
import com.project.assignment.service.UserService;

@SpringBootTest
public class TestingApplication {

	@Mock
	private UserService userService;

	@Mock
	private SlotService slotService;

	@Mock
	private ConsultantService consultantService;

	@InjectMocks
	private UserController userController;

	@InjectMocks
	private SlotController slotController;

	@InjectMocks
	private ConsultantController consultantController;

	@Test
	public void testRegisterClient_Success() {
		Client client = new Client();
		client.setName("John Doe");
		client.setEmail("john@example.com");
		client.setPhoneNo("1234567891");
		client.setAge(29);
		client.setRole("client");

		when(userService.registerClient(any(Client.class))).thenReturn(client);

		ResponseEntity<User> response = userController.registerClient(client);

		assert response.getStatusCode().equals(HttpStatus.CREATED);
		assert response.getBody().equals(client);
	}
	
	@Test
	public void testRegisterConsultant_Success() {
		Consultant consultant = new Consultant();
		consultant.setName("John Doe");
		consultant.setEmail("john@example.com");
		consultant.setPhoneNo("1234567891");
		consultant.setAge(29);
		consultant.setRole("consultant");
		consultant.setAreaOfExpertise("Software");
		consultant.setExperience(5);

		when(userService.registerConsultant(any(Consultant.class))).thenReturn(consultant);

		ResponseEntity<User> response = userController.registerConsultant(consultant);

		assert response.getStatusCode().equals(HttpStatus.CREATED);
		assert response.getBody().equals(consultant);
	}

	@Test
	public void testRegisterClient_DuplicateEmail_Error() {
		Client client = new Client();
		client.setName("John Doe");
		client.setEmail("john@example.com");
		client.setPhoneNo("1234567891");
		client.setAge(29);
		client.setRole("client");

		when(userService.registerClient(any(Client.class))).thenThrow(new ValidationException("Email already exists"));

		ResponseEntity<User> response = userController.registerClient(client);

		assert response.getStatusCode().equals(HttpStatus.BAD_REQUEST);
		assert response.getBody().toString().contains("Email already exists");
	}

	@Test
	public void testCreateSlot_Success() {
		Slot slot = new Slot();
		slot.setConsultantId(1L);
		slot.setStartTime(LocalDateTime.parse("2024-03-15T09:00:00"));
		slot.setEndTime(LocalDateTime.parse("2024-03-15T10:00:00"));
		slot.setStatus("AVAILABLE");
		slot.setRole("consultant");

		when(slotService.createSlot(any(Slot.class))).thenReturn(slot);

		ResponseEntity<Slot> response = slotController.createSlot(slot);

		assert response.getStatusCode().equals(HttpStatus.CREATED);
		assert response.getBody().equals(slot);
	}

	@Test
	public void testConsultantSearch_Success() {
		List<Consultant> consultants = new ArrayList<>();
		// Populate consultants list with mock data
		Consultant consultant1 = new Consultant();
	    consultant1.setId(1L);
	    consultant1.setName("John Doe");
	    consultant1.setEmail("john@example.com");
	    consultant1.setPhoneNo("1234567891");
		consultant1.setAge(29);
	    consultant1.setRole("consultant");
	    consultant1.setExperience(5);
	    consultant1.setAreaOfExpertise("Marketing");

	    Consultant consultant2 = new Consultant();
	    consultant2.setId(2L);
	    consultant2.setName("Jane Smith");
	    consultant2.setEmail("jane@example.com");
	    consultant2.setPhoneNo("1234567891");
		consultant2.setAge(29);
	    consultant2.setRole("consultant");
	    consultant2.setExperience(7);
	    consultant2.setAreaOfExpertise("Finance");

	    consultants.add(consultant1);
	    consultants.add(consultant2);

		when(consultantService.searchConsultants("Marketing", 5)).thenReturn(consultants);

		ResponseEntity<List<Consultant>> response = consultantController.searchConsultants("Marketing", 5);

		assert response.getStatusCode().equals(HttpStatus.OK);
		assert response.getBody().equals(consultants);
	}
}
