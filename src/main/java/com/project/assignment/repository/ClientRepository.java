package com.project.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.assignment.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
}