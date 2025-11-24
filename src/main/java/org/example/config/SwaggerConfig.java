package org.example.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI mutantOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Detector de Mutantes - Analizador de ADN")
                .description("Sistema de deteccion de mutantes, Analiza secuencias de ADN.")
                .version("2.0.0")
                .contact(new Contact().name("Luna Joaquin").email("Jmluna200420@gmail.com"))); 
    }
}
