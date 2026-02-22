package fr.aba.poc.library.config;

import fr.aba.poc.library.generated.client.ApiClient;
import fr.aba.poc.library.generated.client.api.BooksApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Library API").version("1.0.0").description("API de gestion de bibliothèque")
						.contact(new Contact().name("ABA Team").email("contact@aba.fr"))
						.license(new License().name("Apache 2.0")));
	}

	// Bean de configuration de client web
	@Bean
	public BooksApi booksApi() {

		ApiClient apiClient = new ApiClient();
		apiClient.setBasePath("http://localhost:8484");

		return new BooksApi(apiClient);
	}
}
