package com.example.graphqlexamplebykotlin.config;

import graphql.execution.ExecutionStrategy;
import graphql.kickstart.servlet.apollo.ApolloScalars;
import graphql.language.StringValue;
import graphql.scalars.ExtendedScalars;
import graphql.schema.Coercing;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class GraphQLConfiguration {

	@Bean
    public Map<String, ExecutionStrategy> executionStrategies() {
        Map<String, ExecutionStrategy> executionStrategyMap = new HashMap<>();
        executionStrategyMap.put("queryExecutionStrategy", new AsyncTransactionalExecutionStrategy());
        return executionStrategyMap;
    }
	
	@Bean
    public GraphQLScalarType DateTime() {
        return ExtendedScalars.DateTime;
    }

    @Bean
    public GraphQLScalarType Date() {
        return ExtendedScalars.Date;
    }

    @Bean
    public GraphQLScalarType JSON() {
        return ExtendedScalars.Json;
    }

    @Bean
    public GraphQLScalarType uploadScalar() {
        return ApolloScalars.Upload;
    }

    @Bean
    public GraphQLScalarType Instant() {
        return GraphQLScalarType.newScalar()
                .name("Instant")
                .description("Built-in java.time.Instant")
                .coercing(new Coercing() {
                    @Override
                    public Instant serialize(Object input) {
                        return getInstant(input);
                    }

                    @Override
                    public Instant parseValue(Object input) {
                        return getInstant(input);
                    }

                    @Override
                    public Instant parseLiteral(Object input) {
                        return getInstant(input);
                    }

                    private Instant getInstant(Object input) {
                        if (input instanceof Instant) {
                            return (Instant) input;
                        } else if (input instanceof String) {
                            return Instant.parse((String) input);
                        } else if (input instanceof StringValue) {
                            return Instant.parse(((StringValue) input).getValue());
                        }

                        return null;
                    }
                }).build();
    }


}