package com.project.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.assignment.entity.Client;
import com.project.assignment.entity.Consultant;
import com.project.assignment.entity.User;
import com.project.assignment.repository.ClientRepository;
import com.project.assignment.repository.ConsultantRepository;
import com.project.assignment.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final ClientRepository clientRepository;
	private final ConsultantRepository consultantRepository;

	@Autowired
	public UserService(UserRepository userRepository, ClientRepository clientRepository,
			ConsultantRepository consultantRepository) {
		this.userRepository = userRepository;
		this.clientRepository = clientRepository;
		this.consultantRepository = consultantRepository;
	}

	public User registerClient(Client client) {
		if (userRepository.existsByEmail(client.getEmail())) {
			throw new IllegalArgumentException("Email already exists");
		}
		return clientRepository.save(client);
	}

	public User registerConsultant(Consultant consultant) {
		if (userRepository.existsByEmail(consultant.getEmail())) {
			throw new IllegalArgumentException("Email already exists");
		}
		return consultantRepository.save(consultant);
	}
}
