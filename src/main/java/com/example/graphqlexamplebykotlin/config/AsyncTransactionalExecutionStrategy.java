package com.example.graphqlexamplebykotlin.config;

import graphql.ExecutionResult;
import graphql.execution.AsyncExecutionStrategy;
import graphql.execution.ExecutionContext;
import graphql.execution.ExecutionStrategyParameters;
import graphql.execution.NonNullableFieldWasNullException;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.concurrent.CompletableFuture;

@Component
public class AsyncTransactionalExecutionStrategy extends AsyncExecutionStrategy {

	@Override
    @Transactional
    public CompletableFuture<ExecutionResult> execute(ExecutionContext executionContext, ExecutionStrategyParameters parameters) throws NonNullableFieldWasNullException {
        return super.execute(executionContext, parameters);
    }
}