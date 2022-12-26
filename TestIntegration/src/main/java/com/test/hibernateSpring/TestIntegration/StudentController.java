package com.test.hibernateSpring.TestIntegration;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	SessionFactory sessionFactory;
	
	@RequestMapping("/SingleRecord")
	public Student showSingleData() {
		Session session = sessionFactory.openSession();		
		Student student = session.load(Student.class, 101);
		System.out.println(student);
		return student;	
	}
	
	@RequestMapping("/AllRecord")
	public List showAllData() {
		Session session = sessionFactory.openSession();
		String hql = "from Student";
		Query query = session.createQuery(hql);
		List result = query.list();		
		System.out.println(result);
		return result;
	}
	
	
	
	
	
}
