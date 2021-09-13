package com.sdcc.gpao;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;




@SpringBootApplication
@EnableSwagger2
public class GpaoRestApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(GpaoRestApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	  return builder.sources(GpaoRestApplication.class);
	}
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sdcc.gpao"))
                .paths(PathSelectors.any())
                .build();
    }
	
	private ApiInfo apiInfo() {
		 return new ApiInfoBuilder().title("Documentation de l'API REST de la GPAO")
		 .description("API REST pour gérer les services back-end de la GPAO")
		 .contact(new Contact("LENGUE Damico", "SODECOTON", "damico.lengue@sodecoton.cm"))
		 .version("1.0")
		 .build();
	}
    
}
