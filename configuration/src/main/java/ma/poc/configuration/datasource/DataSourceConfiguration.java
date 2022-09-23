package ma.poc.configuration.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfiguration {

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public HikariDataSource dataSource() {
		HikariDataSource ds = DataSourceBuilder.create().type(HikariDataSource.class).build();
		return ds;
	}
}
