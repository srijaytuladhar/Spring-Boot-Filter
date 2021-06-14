package com.spring.restapi.restapi;

import com.spring.restapi.restapi.filter.RequestResponseFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@RestController
public class RestapiApplication {

	private static final String httpUrl = "/students/*";


	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);
	}

	@RequestMapping(value = "/")
	public ResponseEntity<Object> homePage() {
		return new ResponseEntity<>("Homepage", HttpStatus.OK);
	}


	@Bean
	public FilterRegistrationBean<RequestResponseFilter> loggingFilter(){
		FilterRegistrationBean<RequestResponseFilter> registrationBean
				= new FilterRegistrationBean<>();

		registrationBean.setFilter(new RequestResponseFilter());
		registrationBean.addUrlPatterns(httpUrl);

		return registrationBean;
	}
}
