package com.nt.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class EmployeeBO {
	private Integer empNo;
	private String eName;
	private String job;
	private Float sal;
	private Integer deptNo;
}
