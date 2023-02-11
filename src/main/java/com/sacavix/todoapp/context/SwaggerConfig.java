package com.sacavix.todoapp.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration /*la clase con esta configuracipon tiene la capacidad de crear bines, los cuales forman parte de la aplication context de spring/springboot*/
@EnableSwagger2 /*Habilitamos Swagger2 en el proyecto*/
public class SwaggerConfig {
    @Bean /*Bean principal*/
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sacavix.todoapp.controller")) /*Swagger va a escanear lo que esté dentro del paquete controler
                y va a buscar todas las clases que tengan @RestController para renderizar los metodos y documentar la api creada*/
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() { /*El bean tiene un grupo de información asociado*/
        return new ApiInfo(/*Es la información de la api que se mostrará en el swagger*/
                "ToDo API",
                "La API REST de ToDo App.",
                "v1",
                "Terms of service",
                new Contact("SACAViX Tech", "www.example.com", "myeaddress@company.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}
