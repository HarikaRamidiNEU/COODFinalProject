package edu.neu.csye6200.service.singleton;

import edu.neu.csye6200.service.factory.ImmunizationFactory;

public class ImmunizationFactorySingleton {
	private static ImmunizationFactorySingleton instance;

	private ImmunizationFactorySingleton() {
	}

	public synchronized static ImmunizationFactorySingleton getInstance() {
		if (instance == null) {
			instance = new ImmunizationFactorySingleton();
		}
		return instance;
	}
	
	public ImmunizationFactory getFactory() {
		return new ImmunizationFactory();
	}
}
