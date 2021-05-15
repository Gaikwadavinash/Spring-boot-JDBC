package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAOImpl;
import com.nt.dao.IEmployeeDAO;
import com.nt.dto.EmployeeDTO;
@Service("empService")
public class EmployeeMangServiceImpl implements IEmployeeMangService {
@Autowired
	private IEmployeeDAO dao;
public EmployeeMangServiceImpl() {
dao= new EmployeeDAOImpl();
	//dao= new EmployeeDAOImpl2();
	//dao= new EmployeeDAOImpl3();
	//dao= new EmployeeDAOImpl4();
}
/*	
@Override
	public EmployeeDTO fetchEmployee(int eno) {
		//get DAO Class
		EmployeeBO bo=dao.getEmployeeDetails(eno);
		//convert bo to dto
		EmployeeDTO dto= new EmployeeDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}
*/


@Override
	public List<EmployeeDTO> fetchEmployeeByDesg(String desg1, String desg2, String desg3) {
	List<EmployeeBO> list=dao.getEmployeeByDesg(desg1, desg2, desg3);
//convert bo to dto
	List<EmployeeDTO> listdto= new ArrayList();
list.forEach(bo->{
EmployeeDTO dto= new EmployeeDTO();	
	BeanUtils.copyProperties(bo, dto);
	listdto.add(dto);
});
return listdto;
	}
}
