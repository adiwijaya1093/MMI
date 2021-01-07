package com.karyawan.karyawanjpacrud.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.karyawan.karyawanjpacrud.model.Employee;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, String>{

	@Query(value = "SELECT *\r\n" + 
		      "FROM Employee A\r\n" + 
		      "WHERE A.id_number = :key " + 
		      "AND A.is_delete = 0", nativeQuery = true)
	Employee searchById(@Param("key") int key);
	
	@Query(value = "SELECT *\r\n" + 
		      "FROM Employee A\r\n" + 
		      "WHERE A.is_delete = :isDel", nativeQuery = true)
	Collection<Employee> getListActiveEmployee(@Param("isDel") int isDelete); 
	
}
