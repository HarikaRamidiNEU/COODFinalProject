package edu.neu.csye6200.controller;

import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.service.StudentService;
import edu.neu.csye6200.util.SeedDataUtility;

@Component
public class StudentController {

	private String filePath = Paths.get("", "src/main/resources", "Students.csv").toAbsolutePath().toString();

	@Autowired
	StudentService studentService;

	public void addTestData() {

		studentService.saveStudents(new SeedDataUtility().populateStudentData(filePath));
	}

	public void displayAllStudents() {
		studentService.getAllStudents().forEach(System.out::println);
	}

	public List<Student> getStudents() {
		return studentService.getAllStudents();
	}

	public void removeStudentById(Integer id) {
		studentService.deleteStudentById(id);
	}

	public Optional<Student> readStudentById(Integer id) {
		return studentService.getStudentById(id);
	}

	public void addStudent(String csv) {
		studentService.saveStudent(csv);
	}
}
