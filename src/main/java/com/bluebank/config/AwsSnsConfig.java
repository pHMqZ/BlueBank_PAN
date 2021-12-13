package com.bluebank.config;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import lombok.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;

@Configuration
public class AwsSnsConfig {

	public static final String SECRET_KEY = "kzS6we1BkiTAI2xQFag505M5LJTp2E5DfTEfaFPt";
	public static final String ACCESS_KEY = "AKIA6BZRT7L44PGQA54V";

	@Primary
	@Bean
	public AmazonSNSClient getSnsClient() {

		return (AmazonSNSClient) AmazonSNSClientBuilder.standard().withRegion(Regions.US_EAST_1)
				.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY)))
				.build();

	}

}