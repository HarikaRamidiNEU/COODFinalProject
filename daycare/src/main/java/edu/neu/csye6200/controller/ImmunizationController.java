/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200.controller;

import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.neu.csye6200.model.Immunization;
import edu.neu.csye6200.service.ImmunizationService;
import edu.neu.csye6200.util.SeedDataUtility;

@Component
public class ImmunizationController {

	private String filePath = Paths.get("", "src/main/resources", "Vaccines.csv").toAbsolutePath().toString();

	@Autowired
	ImmunizationService immunizationService;

	public void addTestData() {
		immunizationService.saveVaccinations(new SeedDataUtility().populateVaccineData(filePath));
	}

	public void displayAllVaccines() {
		immunizationService.getAllVaccinations().forEach(System.out::println);
	}

	public List<Immunization> getAllVaccines() {
		return immunizationService.getAllVaccinations();
	}

	public void removeVaccineById(Integer id) {
		immunizationService.deleteVaccinationsById(id);
	}

	public Optional<Immunization> getVaccinesById(Integer id) {
		return immunizationService.getVaccinationById(id);
	}

	public void addVaccine(String csv) {
		immunizationService.saveVaccination(csv);
	}
}
