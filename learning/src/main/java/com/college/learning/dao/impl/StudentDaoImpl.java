package com.college.learning.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.college.learning.dao.StudentDao;
import com.college.learning.vo.StudentVO;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<StudentVO> getStudentDetails() {
		StudentVO studentVO = new StudentVO();
		
		String query = "SELECT * FROM STUDENT_RECORD ";
		
		studentVO = jdbcTemplate.query(query.toString(),
				new ResultSetExtractor<StudentVO>() {
			public StudentVO extractData(ResultSet rs) throws SQLException{
				StudentVO studentVO = new StudentVO();
				while(rs.next()) {
					studentVO.setSname(rs.getString("sname"));
				}
				return studentVO;
			}
			
		});
			
		return null;
	}

	@Override
	public String saveStudentDetails(StudentVO studentVO) {
		String insertQuery="insert into student_record values(?,?,?,?)";
		String result=null;
		try {
			Object[] params= {studentVO.getSid(),studentVO.getSname(),studentVO.getAddress(),studentVO.getAge()};
			int rows=jdbcTemplate.update(insertQuery,params);
			if(rows==1) {
				result="Success";
			}			
			return result;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return result;
	}

}
