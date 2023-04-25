package com.example.graphqlexamplebykotlin.domain;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.function.Supplier;

@RequiredArgsConstructor
@Component
public class MainQuery implements GraphQLQueryResolver {

	private final MemberRepository memberRepository;
	private final DepartmentRepository departmentRepository;
	
	public PageDTO<Member> members(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Member> memberPate = memberRepository.findAll(pageable);
        return makePageDTO(memberPate);
    }

	protected static <T> PageDTO<T> makePageDTO(Page<T> page) {
        return buildPageDTO(page.getContent(), page.getTotalElements(), page.getTotalPages());
    }
	
	private static <T> PageDTO<T> buildPageDTO(List<T> content, long totalElements, int totalPages) {
        return PageDTO.<T>builder()
                .content(content)
                .totalElements(totalElements)
                .totalPages(totalPages)
                .build();
    }
	
	public Member member(String id) {
		return memberRepository.findById(id)
				.orElseThrow(handleEntityNotFound(Member.class, id));
	}
	
	private Supplier<RuntimeException> handleEntityNotFound(Class<?> entity, Serializable id) {
        return () -> new RuntimeException(String.format("Unable to find %s with id %s", entity.getSimpleName(), id));
    }
}
