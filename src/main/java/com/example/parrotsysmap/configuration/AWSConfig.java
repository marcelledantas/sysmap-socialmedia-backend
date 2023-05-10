package com.example.parrotsysmap.configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSConfig {

    @Bean
    public AmazonS3 amazonS3() {
        final BasicAWSCredentials awsCredentials = new BasicAWSCredentials("key", "secretkey");

        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withEndpointConfiguration( new AwsClientBuilder.EndpointConfiguration(this.amazonS3Endpoint, Regions.US_EAST_1.getName()))
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();

        return s3client;
    }

    @Value("${amazonS3Endpoint}")
    private String amazonS3Endpoint;

}
