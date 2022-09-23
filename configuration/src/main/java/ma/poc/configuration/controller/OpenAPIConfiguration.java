package ma.poc.configuration.controller;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenAPIConfiguration {

	@Bean
	public GroupedOpenApi api() {
		return GroupedOpenApi.builder().group("mypoc").pathsToMatch("/**").build();
	}

	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI()
				.info(new Info().title("Contrat d'interface").version("1.0.0")
						.license(new License().name("http://alaa.com")))
				.externalDocs(
						new ExternalDocumentation().description("documentation officielle").url("http://alaa.com"));
	}

}
