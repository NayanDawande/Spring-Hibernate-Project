package com.test.hibernateSpring.TestIntegration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	SessionFactory sessionFactory;
	
	@RequestMapping("/SingleRecord")
	public Student showAllData() {
		Session session = sessionFactory.openSession();		
		Student student = session.load(Student.class, 101);
		System.out.println(student);
		return student;
		
		
	}
	
	
	
	
}
