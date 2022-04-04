package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService service;
	@GetMapping("/")
	public List<Student> findAll(){
		return service.findAll();
		
	}
	@DeleteMapping("/delete/{studentname}")
	public void deleteStudent(@PathVariable("studentname") Student s) {
		service.delete(s);
	}

 
	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student s) {
		service.save(s);
		return s;
	}
}
