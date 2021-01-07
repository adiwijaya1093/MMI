package com.karyawan.karyawanjpacrud.dto;

import com.karyawan.karyawanjpacrud.model.Employee;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReqUpdateEmployeeDTO {
	
	private int idNumber;
	
	private Employee employee;
	
}
