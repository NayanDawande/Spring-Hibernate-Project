package com.test.hibernateSpring.TestIntegration;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping("/")
	public List showAllData() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Student");
		List result = query.list();		
		System.out.println(result);
		return result;
	}
	
	@RequestMapping("/SumId")
	public List sumID() {
		
		Session session = sessionFactory.openSession();
		Query query  = session.createQuery("select sum(id) from Student");
		List<Integer> list = query.list();
		System.out.println("Sum of ID's "+list.get(0));
		return list;
	}
	
	@RequestMapping("/CountData")
	public List countID() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("select count(id) from Student");
		List <Integer> list = query.list();
		System.out.println("Count the Data "+list.get(0));			
		return list;
	}
	
	@PutMapping("/updateID")
	public Session updateID(@RequestBody Student student) {      //by this code database data change and postman meg errorshow
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.update(student);
		System.out.println("Updated Student ");
		transaction.commit();
		return session;
	}
	
	@PostMapping("/insertData/{id}/{name}")
	public Student insertData(@PathVariable int id, @PathVariable String name) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Student student = new Student(id,name);
		session.save(student);
		transaction.commit();
		System.out.println("Inserted new Student data ");
		return student;
	}
	
	@DeleteMapping("/DeleteStudent")
	public Student delete() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
	    Student student = session.load(Student.class,101);	
		session.delete(student) ;
		transaction.commit();
		System.out.println("Deleted Student "+session);
		
		return student;
				
		 
	}
	
//	@DeleteMapping("/DeleteStudent")
//	public Student delete() {
//		Session session = sessionFactory.openSession();
//		Transaction transaction = session.beginTransaction();
//	    Student student = session.load(Student.class,101);	
//		session.delete(student) ;
//		transaction.commit();
//		System.out.println("Deleted Student "+session);
//		
//		return student;
//				
//		 
//	}
	
	
	
	
}
