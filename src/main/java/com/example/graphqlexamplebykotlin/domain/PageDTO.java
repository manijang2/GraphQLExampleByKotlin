package com.example.graphqlexamplebykotlin.domain;

import lombok.Builder;

import java.util.List;

@Builder
public class PageDTO<T> {
    private final List<T> content;
    private final long totalElements;
    private final int totalPages;
}