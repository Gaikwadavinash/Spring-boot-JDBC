package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface IEmployeeMangService {
//public EmployeeDTO fetchEmployee(int eno);
public List<EmployeeDTO> fetchEmployeeByDesg(String desg1,String desg2,String desg3);
}
