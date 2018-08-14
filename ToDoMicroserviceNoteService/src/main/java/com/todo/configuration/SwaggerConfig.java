package com.todo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.ApiInfo;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * purpose: This class is designed to configure swagger
 * 
 * @author JAYANTA ROY
 * @version 1.0
 * @since 10/07/18
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo()).select()
				.paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return (regex("/.*"));
	}

	@SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("TODO Notes").description("Save paper,Save Tree,Save earth, Save NOTE")
				.termsOfServiceUrl("").contact("roy.jayanta1201@gmail.com").license("no licence")
				.licenseUrl("roy.jayanta1201@gmail.com").version("1.0").build();
	}

	@Bean
	SecurityConfiguration security() {
		return new SecurityConfiguration(null, null, null, null, "JWTToken", ApiKeyVehicle.HEADER, "JWTToken", ",");
	}

}
