package ma.poc.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import ma.poc.configuration.controller.ApplicationConfiguration;
import ma.poc.configuration.controller.ControllerConfiguration;
import ma.poc.configuration.controller.OpenAPIConfiguration;
import ma.poc.configuration.controller.WebConfiguration;
import ma.poc.configuration.datasource.DataSourceConfiguration;
import ma.poc.configuration.datasource.PersitenceConfiguration;

@EnableAutoConfiguration
@SpringBootApplication
@Import({ PersitenceConfiguration.class, ApplicationConfiguration.class, DataSourceConfiguration.class,
		ControllerConfiguration.class, WebConfiguration.class, OpenAPIConfiguration.class })
public class ServicesApplication {

	public static void main(String[] args) throws Exception {
		new SpringApplication(ServicesApplication.class).run();
	}
}