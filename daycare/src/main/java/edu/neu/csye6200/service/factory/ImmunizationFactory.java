/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.service.factory;

import edu.neu.csye6200.model.Immunization;

public class ImmunizationFactory {
	public Immunization getObject(String csvData) {
		return new Immunization(csvData);
	}
}
