package com.bluebank.config;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.bluebank.model.AwsLambdaConfirm;
import com.bluebank.repository.AwsLambdaRepository;

public class AwsLambdaConfig {
	
	@Autowired
	private AwsLambdaRepository awsLambdaRepository;
	
	@Bean
	public Supplier<List<AwsLambdaConfirm>> Confirm(){
		return () -> awsLambdaRepository.buildLambda();
	}
	
}
