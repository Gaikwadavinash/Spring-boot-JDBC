
package com.nt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;
@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
//private static final String Get_Employee_Record_By_Eno="SELECT EMPNO,ENAME,JOB,SAL ,DEPTNO FROM EMP WHERE EMPNO=?";	
private static final String Get_Employee_By_Desg="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN(?,?,?)";
@Autowired
private JdbcTemplate jt;
/*
	public EmployeeBO getEmployeeDetails(int eno) {
		
	EmployeeBO bo=jt.queryForObject(Get_Employee_Record_By_Eno, 
			
			new EmployeeRowMapper(),eno);
	return bo;	
	}//
	
	
	//inner class started(Nested Inner class)
	public static class EmployeeRowMapper implements RowMapper<EmployeeBO>{
		
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
/*
@Override
	public List<EmployeeBO> getEmployeeByDesg(String desg1, String desg2, String desg3) {

	List<EmployeeBO> listBo=jt.query(Get_Employee_By_Desg, 
			                                  new ResultSetExtractor<List<EmployeeBO>>() {
@Override
public List<EmployeeBO> extractData(ResultSet rs)
		                                                                            throws SQLException, DataAccessException {

List<EmployeeBO> listBo= new ArrayList<EmployeeBO>();
while(rs.next()) {
	EmployeeBO bo= new EmployeeBO();
	
bo.setEmpNo(rs.getInt(1));
bo.setEName(rs.getString(2));
bo.setJob(rs.getString(3));
bo.setSal(rs.getFloat(4));
bo.setDeptNo(rs.getInt(5));	
//add each object to list collection
listBo.add(bo);
}//ens while
return listBo;
}//end Method
	}//end args2
	,desg1,desg2,desg3);
		return listBo;
	}
*/
/*
//LAMBDA Expression 
	public List<EmployeeBO> getEmployeeByDesg(String desg1, String desg2, String desg3) {
List<EmployeeBO>listBo1=jt.query(Get_Employee_By_Desg,
		rs->{
List<EmployeeBO> listbo=new ArrayList();			
		while(rs.next()) {	
EmployeeBO bo= new EmployeeBO();
bo.setEmpNo(rs.getInt(1));
bo.setEName(rs.getString(2));
bo.setJob(rs.getString(3));	
bo.setSal(rs.getFloat(4));
bo.setDeptNo(rs.getInt(5));
listbo.add(bo);
		}
		return listbo;	
}
,desg1,desg2,desg3);

return listBo1;	
}

*/

//Each record of bo class object and 
public List<EmployeeBO> getEmployeeByDesg(String desg1, String desg2, String desg3) {
/*
	BeanPropertyRowMapper<EmployeeBO> rowMapper= new BeanPropertyRowMapper(EmployeeBO.class);
	  List<EmployeeBO> listBo=jt.query(Get_Employee_By_Desg,
			  
			 new RowMapperResultSetExtractor<EmployeeBO>(rowMapper)  
			  
			  
			  ,desg1,desg2,desg3);

return listBo;
*/
 return jt.query(Get_Employee_By_Desg,
		 new RowMapperResultSetExtractor<EmployeeBO>( new BeanPropertyRowMapper(EmployeeBO.class)),desg1,desg2,desg3);
		 
}
}//end of DAO class
