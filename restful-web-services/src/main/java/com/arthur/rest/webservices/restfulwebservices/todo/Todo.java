package com.arthur.rest.webservices.restfulwebservices.todo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Todo {
	@Id
	@GeneratedValue
	private Long id; 
	private String lastname;
	private String firstname;
	private String course;
	private String gender;
	private Date birthDay;
	private boolean isDone;
	
	
	public Todo() {}
	public Todo(Long id, String lastname, String firstname, String course, String gender, Date birthDay,
			boolean isDone) {
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.course = course;
		this.gender = gender;
		this.birthDay = birthDay;
		this.isDone = isDone;
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Date getBirthDay() {
		return birthDay;
	}


	public void setBirthDay(Date birthDate) {
		this.birthDay = birthDate;
	}


	public boolean isDone() {
		return isDone;
	}


	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (id != other.id)
			return false;
		return true;
	}
	

}
