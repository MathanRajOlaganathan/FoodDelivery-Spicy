package com.fooddelivery.spicy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.StringVendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;

/**
 * The Swagger configuration to enable the api documentation.
 * @author Mathan Raj O
 * @version 1.0
 * @since 02-11-2020
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket(){

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fooddelivery.spicy"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {

        Contact contact = new Contact("Mathan Raj Olaganathan","https://www.linkedin.com/in/mathanrajo",
                "omrfrance1990@gmail.com");

        StringVendorExtension listVendorExtension = new StringVendorExtension("Role", "Software Developer");
        ApiInfo apiInfo = new ApiInfo("Spicy-Food Delivery",
                "Spicy - Food Delivery RestFul Service API",
                "1.0",
                "",
                (springfox.documentation.service.Contact) contact,
                "Spicy-Food Delivery RestFul Service - Github"
                ,"https://github.com/MathanRajOlaganathan/FoodDelivery-Spicy",
                Arrays.asList(listVendorExtension));
        return apiInfo;
    }
}
