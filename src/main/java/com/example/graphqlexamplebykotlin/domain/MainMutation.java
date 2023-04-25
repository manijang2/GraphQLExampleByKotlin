package com.example.graphqlexamplebykotlin.domain;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.function.Supplier;

@RequiredArgsConstructor
@Component
public class MainMutation implements GraphQLMutationResolver {

	private final MemberRepository memberRepository;
	private final DepartmentRepository departmentRepository;
	
	public Member addMember(MemberInput input) {
		Member member = new Member();
		member.setUserId(input.getUserId());
		member.setPassword(input.getPassword());
		member.setEmail(input.getEmail());
		member.setName(input.getName());
		
		Department department = departmentRepository.findById(input.getDepartmentId())
				.orElseThrow(handleEntityNotFound(Member.class, input.getDepartmentId()));
		
		member.setDepartment(department);
		return memberRepository.save(member);
	}
	
	private Supplier<RuntimeException> handleEntityNotFound(Class<?> entity, Serializable id) {
        return () -> new RuntimeException(String.format("Unable to find %s with id %s", entity.getSimpleName(), id));
    }
}