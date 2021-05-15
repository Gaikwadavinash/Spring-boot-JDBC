/*
package com.nt.dao;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;
@Repository("empDAO")
public class EmployeeDAOImpl3 implements IEmployeeDAO {
private static final String Get_Employee_Record_By_Eno="SELECT EMPNO,ENAME,JOB,SAL ,DEPTNO FROM EMP WHERE EMPNO=?";	

@Autowired
private JdbcTemplate jt;

	public EmployeeBO getEmployeeDetails(int eno) {
		EmployeeBO ebo= jt.queryForObject(Get_Employee_Record_By_Eno,
				
				(rs,rowNum)->{
					EmployeeBO bo= new EmployeeBO();
					bo.setEmpNo(rs.getInt(1));
					bo.setEName(rs.getString(2));
					bo.setJob(rs.getString(3));
					bo.setSal(rs.getFloat(4));
					bo.setDeptNo(rs.getInt(5));
					return bo;	
			},eno);
		
		
		return ebo;
		
		
		
	}	
		
		
		
		
		/*
		
	EmployeeBO bo=jt.queryForObject(Get_Employee_Record_By_Eno, 
			
			new RowMapper<EmployeeBO>() {
				@Override
				public EmployeeBO mapRow(ResultSet rs, int rowNum) throws SQLException {
					EmployeeBO bo= new EmployeeBO();
					bo.setEmpNo(rs.getInt(1));
					bo.setEName(rs.getString(2));
					bo.setJob(rs.getString(3));
					bo.setSal(rs.getFloat(4));
					bo.setDeptNo(rs.getInt(5));
					return bo;
				}
		},eno);
	return bo;	
	}//
	
	*/
	//inner class started(Nested Inner class)
	//public static class RowMapper implements RowMapper<EmployeeBO>{
	/*	
	public EmployeeBO mapRow(ResultSet rs, int rowNum)throws SQLException {
		EmployeeBO bo= new EmployeeBO();
		System.out.println("RowNum:"+rowNum);
		bo.setEmpNo(rs.getInt(1));
		bo.setEName(rs.getString(2));
		bo.setJob(rs.getString(3));
		bo.setSal(rs.getFloat(4));
		bo.setDeptNo(rs.getInt(5));	
		return bo;		
	}//rowMapper
	}//inner class
*/
//}//end of DAO class
