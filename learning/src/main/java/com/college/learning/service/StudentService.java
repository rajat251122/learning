package com.college.learning.service;

import java.util.List;

import com.college.learning.entity.Student;

public interface StudentService {
	
	public List<Student> getStudentDetails();
	public Student saveStudent(Student student);
	public String deleteStudentById(Integer id);
	
	

}
