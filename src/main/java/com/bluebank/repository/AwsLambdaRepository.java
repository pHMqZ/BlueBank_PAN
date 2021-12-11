package com.bluebank.repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.bluebank.model.AwsLambdaConfirm;

@Repository
public class AwsLambdaRepository {
	
	public List<AwsLambdaConfirm> buildLambda(){
		return Stream.of(
				new AwsLambdaConfirm("Cadastro realizado com sucesso")
				).collect(Collectors.toList());
	}

}
