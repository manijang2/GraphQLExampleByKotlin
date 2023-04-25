package com.example.graphqlexamplebykotlin.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "member")
public class Member {

	@Id
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	Department department;
}