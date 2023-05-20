package dev.jeffersonfreitas.restapicookbok.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Spring Boot Rest API CookBook!!!")
                        .description("Projeto destinado a futuras pesquisas")
                        .contact(new Contact().name("Jefferson Freitas").url("https://github.com/jeffersonfreitas-dev")
                                .email("jefferson.dev21@gmail.com"))
                );
    }
}
