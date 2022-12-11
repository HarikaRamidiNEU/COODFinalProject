package edu.neu.csye6200.model;

import javax.persistence.Entity;

import edu.neu.csye6200.util.ConvertUtil;

@Entity
public class Teacher extends AbstractPerson {
	private int credits;

	public Teacher() {
	}

	public Teacher(int age, String name, int credits) {
		super(age, name);
		this.credits = credits;
	}

	public Teacher(int id, int age, String name, int credits) {
		super(id, age, name);
		this.credits = credits;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public Teacher(String csvData) {
		super();
		try {
			String[] field = csvData.split(",");
			this.setId(ConvertUtil.strToInt(field[0]));
			this.setName(field[1]);
			this.setAge(ConvertUtil.strToInt(field[2]));
			this.setCredits(ConvertUtil.strToInt(field[3]));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Teacher{" + "credits=" + credits + "} " + super.toString();
	}
}
