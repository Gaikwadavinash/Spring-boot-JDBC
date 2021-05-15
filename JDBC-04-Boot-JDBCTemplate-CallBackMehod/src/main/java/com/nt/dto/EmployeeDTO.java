package com.nt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class EmployeeDTO {
private Integer empNo;
private String eName;
private String job;
private Float sal;
private Integer deptNo;
}
