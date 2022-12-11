/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Classroom {

	private int classId;
	private int min_age;
	private int max_age;

	private int groupsize;
	private int maxGroups;
	private Set<Integer> studentIdList;
	private Set<Integer> teacherIdList;

	public Classroom(int classId, int min_age, int max_age, int groupsize, int maxGroups) {
		this.classId = classId;
		this.min_age = min_age;
		this.max_age = max_age;
		this.groupsize = groupsize;
		this.maxGroups = maxGroups;
		this.studentIdList = new HashSet<Integer>();
		this.teacherIdList = new HashSet<Integer>();
	}

	public void addStudentId(Integer id) {
		studentIdList.add(id);
	}

	public void addTeacherId(Integer id) {
		teacherIdList.add(id);
	}

	public void deleteStudentId(Integer id) {
		studentIdList.remove(id);
	}

	public void deleteTeacherId(Integer id) {
		teacherIdList.remove(id);
	}

	public int getClassId() {
		return classId;
	}

	public int getMin_age() {
		return min_age;
	}

	public int getMax_age() {
		return max_age;
	}

	public int getGroupsize() {
		return groupsize;
	}

	public int getMaxGroups() {
		return maxGroups;
	}

	public List<Integer> getStudentIdList() {
		return studentIdList.stream().collect(Collectors.toList());
	}

	public List<Integer> getTeacherIdList() {
		return teacherIdList.stream().collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return "Student List :: " + Arrays.toString(this.studentIdList.toArray()) + "/n" + "Teachers List :: "
				+ Arrays.toString(this.teacherIdList.toArray()) + "/n" + "Max Allowed Groups :: " + this.getMaxGroups()
				+ "\n" + "Group Size :: " + this.getGroupsize() + "\n" + "Age Group :: " + this.min_age + "-"
				+ this.max_age; // To change body of generated methods, choose Tools | Templates.
	}

}
