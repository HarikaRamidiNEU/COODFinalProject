package edu.neu.csye6200.service.factory;

import edu.neu.csye6200.model.Student;

public class StudentFactory extends AbstractPersonFactory<Student> {

	@Override
	public Student getObject(String csvData) {
		return new Student(csvData);
	}

	@Override
	public Student getObject() {
		return new Student();
	}
}
