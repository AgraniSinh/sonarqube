package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.dao.StudentDao;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@SpringBootTest
class SonarQubeStudentApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private StudentService service;
	@MockBean
	 private StudentDao dao;

	@Test
	public void findAllTest() {
		when(dao.findAll()).thenReturn(Stream.of(new Student(101,"Rahul","Banglore",180)).collect(Collectors.toList()));
	   assertEquals(1,service.findAll().size());
	}
	
	@Test
	public void saveTest() {
		Student s = new Student(102,"Tahil","Hyderabad",190);
		when(dao.save(s)).thenReturn(s);
		assertEquals(s,dao.save(s));
          
	}
	@Test
	public void deleteTest() {
		Student s= new Student(102,"Tahil","Hyderabad",190);
		service.delete(s);
		verify(dao,times(1)).delete(s);
	}
}
