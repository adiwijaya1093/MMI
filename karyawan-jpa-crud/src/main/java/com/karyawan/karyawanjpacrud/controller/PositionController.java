package com.karyawan.karyawanjpacrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.karyawan.karyawanjpacrud.dao.PositionDAO;
import com.karyawan.karyawanjpacrud.model.Position;
import com.karyawan.karyawanjpacrud.model.response.GlobalReturn;
import com.karyawan.karyawanjpacrud.util.Constanta;

@RestController
public class PositionController {
	
	@Autowired
	private PositionDAO posDao;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.POST, value = "/position/getListPosition")
	public ResponseEntity getEmployee() {
		ResponseEntity res = null;
		
		try {
			final List<Position> pos = posDao.findAll();
			res = ResponseEntity.status(HttpStatus.OK)
					.body(new GlobalReturn(HttpStatus.OK, Constanta.message.SUCCESS, pos));
		} catch (Exception e) {
			res = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new GlobalReturn(HttpStatus.INTERNAL_SERVER_ERROR, Constanta.message.FAILED, e.getMessage()));
		}

		return res;
	}
}
