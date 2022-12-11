package edu.neu.csye6200.controller;

import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.service.TeacherService;
import edu.neu.csye6200.util.SeedDataUtility;

@Component
public class TeacherController {

	private String filePath = Paths.get("", "src/main/resources", "Teachers.csv").toAbsolutePath().toString();

	@Autowired
	TeacherService teacherService;

	public void addTestData() {

		teacherService.saveTeachers(new SeedDataUtility().populateTeacherData(filePath));
	}

	public void displayAllTeachers() {
		teacherService.getAllTeachers().forEach(System.out::println);
	}

	public List<Teacher> getAllTeachers() {
		return teacherService.getAllTeachers();
	}

	public void removeTeacherById(int id) {
		teacherService.deleteTeacherById(id);
	}

	public Optional<Teacher> getTeacherById(int id) {
		return teacherService.getTeacherById(id);
	}

	public void addTeacher(String csv) {
		teacherService.saveTeacher(csv);
	}

}
