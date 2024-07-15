package com.college.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.learning.entity.Student;
import com.college.learning.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	 @GetMapping("/student-details")
	    public List<Student> getStudentDetails() {
	        return studentService.getStudentDetails();
	    }
	 
	 @PostMapping("/save-student")
	    public Student saveEmployee(@RequestBody Student student) {
	        return studentService.saveStudent(student);
	    }
	 
	 @DeleteMapping("/student/{id}")
	    public String deleteStudentById(@PathVariable("id") Integer id) {
	        return studentService.deleteStudentById(id);
	    }
	

}
