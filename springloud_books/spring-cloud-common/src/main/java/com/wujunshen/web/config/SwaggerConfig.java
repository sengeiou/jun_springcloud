package com.wujunshen.web.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * User:frankwoo(吴峻申) <br>
 * Date:2016-10-27 <br>
 * Time:11:10 <br>
 * Mail:frank_wjs@hotmail.com <br>
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2);
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("系统API接口管理")
                .description("各个微服务")
                .contact(new Contact("吴峻申", "", "frank_wjs@hotmail.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0")
                .build();
    }
}