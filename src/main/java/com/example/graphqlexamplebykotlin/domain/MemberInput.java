package com.example.graphqlexamplebykotlin.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberInput {

	private String userId;
	private String password;
	private String name;
	private String email;
	private String departmentId;
}