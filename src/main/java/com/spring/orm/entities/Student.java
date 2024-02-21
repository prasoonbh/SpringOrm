package com.spring.orm.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

@javax.persistence.Entity
@Table (name="student")
public class Student 
{
 @Id
 @Column(name="Id")
  private int Id;
 @Column(name="Name")
  private String Name;
 @Column(name="City")
 private String City;
public Student(int Id, String Name, String City) {
	super();
	this.Id = Id;
	this.Name = Name;
	this.City = City;
}
  public Student()
  {
	  
  }
public int getId() {
	return Id;
}
public void setId(int Id) {
	this.Id = Id;
}
public String getName() {
	return Name;
}
public void setName(String Name) {
	this.Name = Name;
}
public String getCity() {
	return City;
}
public void setCity(String City) {
	this.City = City;
}
  
  
}
