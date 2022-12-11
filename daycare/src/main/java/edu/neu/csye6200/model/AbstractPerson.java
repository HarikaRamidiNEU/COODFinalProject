package edu.neu.csye6200.model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractPerson {
	@Id
	private int id;
	private int age;
	private String name;

	public AbstractPerson() {
	}

	public AbstractPerson(int age, String name) {
		this.age = age;
		this.name = name;
	}

	public AbstractPerson(int id, int age, String name) {
		this.id = id;
		this.age = age;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AbstractPerson{" + "id=" + id + ", age=" + age + ", name='" + name + '\'' + '}';
	}
}
