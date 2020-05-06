package com.defang.orangechain.config;

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
 * Swaggers配置
 * 
 * @Description
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {
	/**
	 * swagger2的配置
	 * 
	 * @Function createRestApi
	 * @Description
	 */
	@Bean
	public Docket createRestApi() {
		ApiInfo apiInfo = new ApiInfoBuilder()
				// 页面标题
				.title("德方后端基础框架")
				// 创建人
				.contact(new Contact("yunliang.yuan", "http://www.defangchain.com", "yunliang.yuan@defangchain.com"))
				// 版本号
				.version("1.0.0-SNAPSHOT")
				// 描述
				.description("API文档").build();
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo).select()
				.apis(RequestHandlerSelectors.basePackage("com.defang.orangechain.web")).paths(PathSelectors.any())
				.build();
	}

}
