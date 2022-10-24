package ma.poc.configuration.controller;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebConfiguration {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

//	@Bean
//	public WebServerFactoryCustomizer<TomcatServletWebServerFactory> customize() {
//		return factory -> {
//			factory.setContextPath("/rest");
//			factory.setPort(8086);
//			factory.addContextCustomizers((context) -> context.setCookieProcessor(new LegacyCookieProcessor()));
//		};
//	}
}
