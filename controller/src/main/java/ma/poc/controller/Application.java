package ma.poc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import ma.poc.configuration.ServicesApplication;
import ma.poc.configuration.controller.ControllerConfiguration;
import ma.poc.configuration.controller.OpenAPIConfiguration;
import ma.poc.configuration.controller.WebConfiguration;
import ma.poc.configuration.datasource.DataSourceConfiguration;
import ma.poc.configuration.datasource.PersitenceConfiguration;
import ma.poc.configuration.services.ApplicationConfiguration;
import ma.poc.persistence.entity.User;
import ma.poc.persistence.repository.UserRepository;

@EnableAutoConfiguration
@SpringBootApplication
@Import({ PersitenceConfiguration.class, ApplicationConfiguration.class, DataSourceConfiguration.class,
		ControllerConfiguration.class, WebConfiguration.class, OpenAPIConfiguration.class })
public class Application {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = new SpringApplication(ServicesApplication.class).run();
		UserRepository repository = context.getBean(UserRepository.class);
		List<User> users = new ArrayList<>();
		for (int i = 0; i < 2000; i++) {
			User user = new User();
			user.setFirstName(UUID.randomUUID().toString());
			user.setLastName(UUID.randomUUID().toString());
			user.setUserName(UUID.randomUUID().toString());
			user.setThePassword(UUID.randomUUID().toString());
			users.add(user);
		}
		repository.saveAll(users);
	}

}
