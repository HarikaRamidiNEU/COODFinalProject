package edu.neu.csye6200.service.factory;

import edu.neu.csye6200.model.Teacher;

public class TeacherFactory extends AbstractPersonFactory<Teacher> {

	@Override
	public Teacher getObject() {
		return new Teacher();
	}

	@Override
	public Teacher getObject(String csvData) {
		return new Teacher(csvData);
	}

}
