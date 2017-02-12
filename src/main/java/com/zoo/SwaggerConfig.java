package com.zoo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2 configuration
 * 
 * reference: 
 * https://github.com/swagger-api/swagger-core/wiki/Annotations#apimodel
 * https://code.aliyun.com/cent/spring-boot-swagger-demo
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * swagger summary bean
     * @return
     */
    @Bean
    public Docket restApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zoo.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    /**
     * API document major information
     * @return
     */
    private ApiInfo apiInfo(){
        ApiInfo apiInfo= (new ApiInfoBuilder())
                .title("Spring Boot Integrate With Swagger Zoo Demo")
                .description("Spring Boot Integrate Swagger")
                .termsOfServiceUrl("https://localhost:8080")
                .license("MIT License")
                .contact(new Contact("Ralph Yang","https://github.com/ycj28c","cyangjob@gmail.com"))
                .version("1.0")
                .build();
        return apiInfo;
    }
}