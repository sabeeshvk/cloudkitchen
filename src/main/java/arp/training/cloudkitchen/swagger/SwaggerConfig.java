package arp.training.cloudkitchen.swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI cloudKitchenOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                .title("Cloud Kitchen API")
                .description("API for menu for Cloud Kitchen")
                .version("1.0")
                .license(new License().name("Apache 2.0")))
                ;
    }    
}