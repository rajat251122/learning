package com.college.learning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.learning.entity.Student;
import com.college.learning.repository.StudentRepository;
import com.college.learning.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Override
    public List<Student> getStudentDetails() {
        List<Student> allStudents = studentRepository.findAll();
        return allStudents;
    }
		
	@Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

	@Override
	public String deleteStudentById(Integer id) {
		if (studentRepository.findById(id).isPresent()) {
			studentRepository.deleteById(id);
            return "Student record has been deleted successfully";
        }
        return "No such Student in the database";  
	}

}
