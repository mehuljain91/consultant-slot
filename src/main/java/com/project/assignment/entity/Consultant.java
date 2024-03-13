package com.project.assignment.entity;

import jakarta.persistence.Entity;

@Entity
public class Consultant extends User {

	private int experience;
	private String areaOfExpertise;

	public Consultant() {

	}

	public Consultant(int experience, String areaOfExpertise) {
		this.experience = experience;
		this.areaOfExpertise = areaOfExpertise;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getAreaOfExpertise() {
		return areaOfExpertise;
	}

	public void setAreaOfExpertise(String areaOfExpertise) {
		this.areaOfExpertise = areaOfExpertise;
	}

}