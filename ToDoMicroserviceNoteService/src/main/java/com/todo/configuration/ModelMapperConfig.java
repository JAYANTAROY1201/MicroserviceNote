package com.todo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

/**
 * purpose: This class is designed to map model
 * 
 * @author JAYANTA ROY
 * @version 1.0
 * @since 17/07/18
 */
@Configuration
public class ModelMapperConfig {
	/**
	 * To get the ModelMapper Object.
	 * 
	 * @return ModelMapper
	 */
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
