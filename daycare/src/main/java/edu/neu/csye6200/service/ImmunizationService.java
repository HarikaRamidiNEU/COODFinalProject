/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.neu.csye6200.model.Immunization;
import edu.neu.csye6200.repository.ImmunizationRepository;
import edu.neu.csye6200.service.factory.ImmunizationFactory;
import edu.neu.csye6200.service.singleton.ImmunizationFactorySingleton;

@Service
public class ImmunizationService {
	@Autowired
	ImmunizationRepository immunizationRepository;
	ImmunizationFactory vf = ImmunizationFactorySingleton.getInstance().getFactory();

	public List<Immunization> getAllVaccinations() {
		List<Immunization> vaccinations = new ArrayList<>();
		immunizationRepository.findAll().forEach(vaccinations::add);
		return vaccinations;
	}

	public void saveVaccinations(List<Immunization> vaccinations) {
		immunizationRepository.saveAll(vaccinations);
	}

	public void saveVaccinations(Immunization vaccination) {
		immunizationRepository.save(vaccination);
	}

	public void saveVaccination(String csv) {
		immunizationRepository.save(vf.getObject(csv));
	}

	public Optional<Immunization> getVaccinationById(Integer id) {
		return immunizationRepository.findById(id);
	}

	public void deleteVaccinationsById(Integer id) {
		immunizationRepository.deleteById(id);
	}

}
