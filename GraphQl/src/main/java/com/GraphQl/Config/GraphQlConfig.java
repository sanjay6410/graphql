package com.GraphQl.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import com.GraphQl.ScalarTypes.LocalizedStringScalar;

import graphql.scalars.ExtendedScalars;

@Configuration
public class GraphQlConfig {

	@Bean
	public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return wiringBuilder -> wiringBuilder.scalar(ExtendedScalars.Locale);
    }
	
	@Bean
	public RuntimeWiringConfigurer runtimeWiringConfigurer1() {
        return wiringBuilder -> wiringBuilder.scalar(LocalizedStringScalar.INSTANCE);
    }
	
	
}
