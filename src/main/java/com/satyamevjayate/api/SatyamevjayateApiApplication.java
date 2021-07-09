package com.satyamevjayate.api;

import com.google.gson.Gson;
import com.satyamevjayate.api.entity.DAOUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication

public class SatyamevjayateApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SatyamevjayateApiApplication.class, args);
	}


}
 