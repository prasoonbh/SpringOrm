package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;


public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = 
    			
    			new ClassPathXmlApplicationContext("config.xml");
    	//Student student = new Student(106,"ram","avadh");
    	StudentDao studentDao = context.getBean("StudentDao",StudentDao.class);
        //int r = studentDao.insert(student);
      
     //   System.out.println("Done"+r);
    
    BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
    boolean go = true;
     while(go)
     {
    	    System.out.println("Press 1 for adding new student");
    	    System.out.println("Press 2 for Display all students");
    	    System.out.println("Press 3 for get details of single student");
    	    System.out.println("press 4 for delete students");
    	    System.out.println("Press 5 for update student");
    	    System.out.println("Press 6 for exit");
    	   
    	    try 
    	    {
    	     int input = Integer.parseInt(br.readLine());	
    	    
    	    
    	     switch(input) 
    	     {
    	     case 1:   // add a new student 
    	    	 	System.out.println("Enter user id: ");
    	    	 	int uId = Integer.parseInt(br.readLine());
    	    	 	
    	    	 	System.out.println("Enter the username:");
    	    	 	String uName = br.readLine() ;
    	    	 	
    	    	 	System.out.println("Enter the city");
    	    	 	String uCity = br.readLine();
    	    	 	
    	    	 	 Student student = new Student();
    	    	 	student.setId(uId);
    	    	 	student.setName(uName);
    	    	 	student.setCity(uCity);
    	    	 	
    	    	 	
    	    	 	
    	    	 	 int r = studentDao.insert(student);
    	    	 	 System.out.println("Student added= "+r);
    	    	 	 System.out.println("***************************");
    	    	 	
    	    	 			break;
    	     case 2: // display all student
    	    	 
    	    	List<Student> allStudents = studentDao.getAllStudents();
    	    	
    	    	for(Student st : allStudents)
    	    	{
    	    		System.out.println("ID: "+ st.getId());
    	    		System.out.println("Name: "+ st.getName());
    	    		System.out.println("City: "+ st.getCity());
    	    		System.out.println("*********************************");
    	    	}
    	    	 break;
    	     case 3: // get single student data
    	    	 
    	    	 System.out.println("Enter user id: ");
 	    	 	int userId = Integer.parseInt(br.readLine());
 	    	 	Student st = studentDao.getStudent(userId);
    	    	 
 	    	 	System.out.println("ID: "+ st.getId());
	    		System.out.println("Name: "+ st.getName());
	    		System.out.println("City: "+ st.getCity());
	    		System.out.println("*********************************");
	    	
    	    	 
    	    	 
    	    	 
    	    	 break;
    	     case 4: // delete srtudents
    	    	 System.out.println("Enter user id: ");
  	    	 	int id = Integer.parseInt(br.readLine());
  	    	 	studentDao.deleteStudent(id);
				System.out.println("Student deleted");
    	    	 break;
    	     case 5: // update student
    	    	 break;
    	     case 6: 
    	    	  go = false;
    	    	 break;
    	     }
    	     
    	    }
    	    catch(Exception e)
    	    {
    	    	System.out.println(e);
    	    }
     }
     
     System.out.println("Thank you for using my application...");
    
    }
}
