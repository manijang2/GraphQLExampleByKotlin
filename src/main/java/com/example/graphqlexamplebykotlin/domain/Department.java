package com.example.graphqlexamplebykotlin.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "department")
public class Department {

	@Id
	@Column(name = "department_id")
	private String departmentId;
	
	@Column(name = "department_name")
	private String departmentName;
}
