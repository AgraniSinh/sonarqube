package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentDao;
import com.example.demo.entity.Student;

@Service
public class StudentService {
@Autowired
	StudentDao dao;

public List<Student>findAll(){
	return dao.findAll();
	}
public void save(Student s) {
	dao.save(s);
}


public void delete(Student s) {
	dao.delete(s);
}
}
