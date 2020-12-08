package com.cg.timecard;

/**Author : Theja Nadhella*/
import static springfox.documentation.builders.PathSelectors.regex;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration

/**This annotation enables the Swagger support in the application*/
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(metadata()).select().paths(regex("/details.*")).build();
	}
	@SuppressWarnings("deprecation")
	private ApiInfo metadata() { 
		return new ApiInfoBuilder().title("Theja Nadhella").description("Accessing Documentation using Swagger").termsOfServiceUrl("https://www.callicoder.com/hibernate-spring-boot-jpa-one-to-one-mapping-example/").contact("Batra, Yatin").version("1.0").build();	
	}
}
