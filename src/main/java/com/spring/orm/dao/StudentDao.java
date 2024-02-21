package com.spring.orm.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao 
{
   private HibernateTemplate hibernateTemplate;	
	
// Insert  student
  @Transactional
   public int insert(Student student)
  {
	 
	  Integer i = (Integer) this.hibernateTemplate.save(student);
	 
	  return i;
  }
  
  // get the single object
  
  public Student getStudent(int Id)
  {
	  Student student = this.hibernateTemplate.get(Student.class,Id );
	  return student;
  }
  
  //get all students 
  
  public List<Student> getAllStudents()
  {
	  List<Student> students = this.hibernateTemplate.loadAll(Student.class);
      return students;
  }
  
  // Deleting the data
  @Transactional
  public void deleteStudent (int Id)
  {
	Student student =  this.hibernateTemplate.get(Student.class, Id);
     this.hibernateTemplate.delete(student);
  }
  
  // updating data
  @Transactional
  public void updateStudent(Student student)
  {
	  this.hibernateTemplate.update(student);
  }
  
  
public HibernateTemplate getHibernateTemplate() {
	System.out.println(hibernateTemplate+" get from student dao");
	return hibernateTemplate;
	
}

public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
	System.out.println(hibernateTemplate+" set from student dao");
}
  
  
}
