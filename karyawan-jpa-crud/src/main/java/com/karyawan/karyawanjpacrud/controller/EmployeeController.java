package com.karyawan.karyawanjpacrud.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.karyawan.karyawanjpacrud.dao.EmployeeDAO;
import com.karyawan.karyawanjpacrud.dto.ReqGetEmployeeByIdNumberDTO;
import com.karyawan.karyawanjpacrud.dto.ReqUpdateEmployeeDTO;
import com.karyawan.karyawanjpacrud.model.Employee;
import com.karyawan.karyawanjpacrud.model.response.GlobalReturn;
import com.karyawan.karyawanjpacrud.util.Constanta;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeDAO emplDao;

	@SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.POST, value = "/employee/getListEmployee")
	public ResponseEntity getEmployee() {
		ResponseEntity res = null;
		
		try {
			final List<Employee> empl = emplDao.findAll();
			res = ResponseEntity.status(HttpStatus.OK)
					.body(new GlobalReturn(HttpStatus.OK, Constanta.message.SUCCESS, empl));
		} catch (Exception e) {
			res = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new GlobalReturn(HttpStatus.INTERNAL_SERVER_ERROR, Constanta.message.FAILED, e.getMessage()));
		}

		return res;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.POST, value = "/employee/getListActiveEmployee")
	public ResponseEntity getActiveEmployee() {
		ResponseEntity res = null;
		
		try {
			final Collection<Employee> empl = emplDao.getListActiveEmployee(Constanta.isDelete.ACTIVE);
			res = ResponseEntity.status(HttpStatus.OK)
					.body(new GlobalReturn(HttpStatus.OK, Constanta.message.SUCCESS, empl));
		} catch (Exception e) {
			res = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new GlobalReturn(HttpStatus.INTERNAL_SERVER_ERROR, Constanta.message.FAILED, e.getMessage()));
		}

		return res;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.POST, value = "/employee/getEmployeeById")
	public ResponseEntity getEmployeeByIdNumber(@RequestBody ReqGetEmployeeByIdNumberDTO param) {
		ResponseEntity res = null;
		
		try {
			final Employee empl = emplDao.searchById(param.getIdNumber());
			res = ResponseEntity.status(HttpStatus.OK)
					.body(new GlobalReturn(HttpStatus.OK, Constanta.message.SUCCESS, empl));
		} catch (Exception e) {
			res = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new GlobalReturn(HttpStatus.INTERNAL_SERVER_ERROR, Constanta.message.FAILED, e.getMessage()));
		}
		
		return res;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.POST, value = "/employee/setEmployee")
	public ResponseEntity setEmployee(@RequestBody Employee param) {
		ResponseEntity res = null;

		try {
			final Employee empl = emplDao.save(param);
			res = ResponseEntity.status(HttpStatus.OK)
					.body(new GlobalReturn(HttpStatus.OK, Constanta.message.SUCCESS, empl));
		} catch (Exception e) {
			res = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new GlobalReturn(HttpStatus.INTERNAL_SERVER_ERROR, Constanta.message.FAILED, e.getMessage()));
		}

		return res;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.POST, value = "/employee/updateEmployee")
	public ResponseEntity updateEmployee(@RequestBody ReqUpdateEmployeeDTO param) {
		ResponseEntity res = null;

		try {
			Employee tempEmployee = emplDao.searchById(param.getIdNumber());
			
			tempEmployee.setBirhtDate(param.getEmployee().getBirhtDate());
			tempEmployee.setGender(param.getEmployee().getGender());
			tempEmployee.setIdNumber(param.getEmployee().getIdNumber());
			tempEmployee.setIsDelete(Constanta.isDelete.ACTIVE);
			tempEmployee.setName(param.getEmployee().getName());
			tempEmployee.setPositionId(param.getEmployee().getPositionId());
			
			final Employee updatedEmpl = emplDao.save(tempEmployee);
			res = ResponseEntity.status(HttpStatus.OK)
					.body(new GlobalReturn(HttpStatus.OK, Constanta.message.UPDATED, updatedEmpl));
		} catch (Exception e) {
			res = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new GlobalReturn(HttpStatus.INTERNAL_SERVER_ERROR, Constanta.message.FAILED, e.getMessage()));
		}

		return res;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.POST, value = "/employee/deleteEmployee")
	public ResponseEntity deleteEmployee(@RequestBody ReqGetEmployeeByIdNumberDTO param) {
		ResponseEntity res = null;

		try {
			Employee tempEmployee = emplDao.searchById(param.getIdNumber());
			
			tempEmployee.setIsDelete(Constanta.isDelete.DELETE);
			
			final Employee deletedEmpl = emplDao.save(tempEmployee);
			res = ResponseEntity.status(HttpStatus.OK)
					.body(new GlobalReturn(HttpStatus.OK, Constanta.message.DELETED, deletedEmpl));
		} catch (Exception e) {
			res = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new GlobalReturn(HttpStatus.INTERNAL_SERVER_ERROR, Constanta.message.FAILED, e.getMessage()));
		}

		return res;
	}

}
