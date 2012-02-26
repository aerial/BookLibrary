package com.example.dbmanager.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private int age;
	private String firstName;
	private String lastName;
	
	
	public Person() {}

    public Long getId() {
        return this.id;
    }

    private void setId(Long aId) {
        this.id = aId;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String aFirstName) {
        this.firstName = aFirstName;
    }
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String aLastName) {
		this.lastName = aLastName;
	}
	
}
