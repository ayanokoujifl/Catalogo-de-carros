package com.atomic.catalogo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

@Configuration
public class JacksonConfig {

	@Bean
	 Hibernate5Module datatypeHibernateModule() {
	    return new Hibernate5Module();
	}
}