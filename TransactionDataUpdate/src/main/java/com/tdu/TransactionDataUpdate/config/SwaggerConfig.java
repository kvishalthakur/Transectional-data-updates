package com.tdu.TransactionDataUpdate.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo()).select()
				.paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/workOrder1/.*"), regex("/workOrder/.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("TransactionDataUpdate API").build();
	}
	
	/*@Bean
	  public DataSource dataSource() {
	      DriverManagerDataSource ds = new DriverManagerDataSource();
	      ds.setDriverClassName("org.postgresql.Driver");
	      ds.setUrl("jdbc:postgresql://awsnlcld001.amwaternp.net:5432/ao-aw-cloudseer3");
	      ds.setUsername("postgres");
	      ds.setPassword("vjedqz)D6kd");
	      ds.setSchema("txn_data");
	      return ds;
	  }*/

}