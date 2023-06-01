package com.generation.blogpessoal.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    OpenAPI springBlogPessoalOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Projeto Blog Pessoal")
                        .description("Projeto pessoal desenvolvido no bootcamp fullstack Java da Generation Brasil")
                        .version("versão 0.0.1")
                        .license(new License()
                                .name("Generation Brasil")
                                .url("https://brazil.generation.org/"))
                        .contact(new Contact()
                                .name("Generation Brasil")
                                .url("https://brazil.generation.org/")
                                .email("contatogeneration@generation.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("GitHub")
                        .url("https://github.com/sofiamarchetti/"));
    }

    @Bean
    OpenApiCustomizer customerGlobalHeaderOpenApiCustomizer(){
        return openApi -> {
            openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations()
                    .forEach(operation -> {
                        ApiResponses apiResponses = operation.getResponses();
                        apiResponses.addApiResponse("200",createApiResponse("Sucesso"));
                        apiResponses.addApiResponse("201",createApiResponse("Objeto já persistido"));
                        apiResponses.addApiResponse("204",createApiResponse("Objeto excluído"));
                        apiResponses.addApiResponse("400",createApiResponse("Erro no envio da requisição"));
                        apiResponses.addApiResponse("401",createApiResponse("Acesso não autorizado"));
                        apiResponses.addApiResponse("403",createApiResponse("Acesso proibido"));
                        apiResponses.addApiResponse("404",createApiResponse("Objeto não foi encontrado"));
                        apiResponses.addApiResponse("500",createApiResponse("Erro na compilação"));
                    }));
        };
    }

    private ApiResponse createApiResponse(String message) {
        return new ApiResponse().description(message);
    }
}