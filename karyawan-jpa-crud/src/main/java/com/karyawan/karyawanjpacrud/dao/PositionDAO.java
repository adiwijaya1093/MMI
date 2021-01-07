package com.karyawan.karyawanjpacrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karyawan.karyawanjpacrud.model.Position;

@Repository
public interface PositionDAO extends JpaRepository<Position, String>{

}
