package com.karyawan.karyawanjpacrud.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Setter
@Getter
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Table(name = "EMPLOYEE")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "BIRTH_DATE")
	private Date birhtDate;
	
	@Column(name = "POSITION_ID")
	private int positionId;
	
	@Column(name = "ID_NUMBER")
	private int idNumber;
	
	@Column(name = "GENDER")
	private int gender;
	
	@Column(name = "IS_DELETE")
	private int isDelete;

}
