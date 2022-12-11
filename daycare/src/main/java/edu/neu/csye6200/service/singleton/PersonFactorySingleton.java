package edu.neu.csye6200.service.singleton;

import edu.neu.csye6200.model.AbstractPerson;
import edu.neu.csye6200.service.factory.AbstractPersonFactory;
import edu.neu.csye6200.service.factory.StudentFactory;
import edu.neu.csye6200.service.factory.TeacherFactory;

public class PersonFactorySingleton {
	public enum FactoryType {
		STUDENT, TEACHER
	}

	private static final PersonFactorySingleton instance = new PersonFactorySingleton();

	private PersonFactorySingleton() {
	}

	public static PersonFactorySingleton getInstance() {
		return instance;
	}

	public <T extends AbstractPerson> AbstractPersonFactory<?> getFactory(FactoryType type) {
		switch (type) {
		case TEACHER:
			return getTeacherFactory();
		case STUDENT:
		default:
			return getStudentFactory();
		}
	}

	public StudentFactory getStudentFactory() {
		return new StudentFactory();
	}

	public TeacherFactory getTeacherFactory() {
		return new TeacherFactory();
	}
}
