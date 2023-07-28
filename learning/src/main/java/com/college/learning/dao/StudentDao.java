package com.college.learning.dao;

import java.util.List;

import com.college.learning.vo.StudentVO;

public interface StudentDao {
	
	public List<StudentVO> getStudentDetails();
	
	public String saveStudentDetails(StudentVO studentVO);

}
