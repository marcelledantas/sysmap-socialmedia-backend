package com.example.parrotsysmap.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.function.Predicate;

@Configuration
public class SwaggerConfig {

//    @Bean
//    public Docket postsApi() {
//        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
//             .apiInfo(apiInfo()).select().paths(postPaths()).build();
//    }
//
//    private Predicate<String> postPaths() {
//        return or(regex("/api/posts.*"), regex("/api/javainuse.*"));
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder().title("JavaInUse API")
//                .description("JavaInUse API reference for developers")
//                .termsOfServiceUrl("http://javainuse.com")
//                .contact("javainuse@gmail.com").license("JavaInUse License")
//                .licenseUrl("javainuse@gmail.com").version("1.0").build();
//    }
}
