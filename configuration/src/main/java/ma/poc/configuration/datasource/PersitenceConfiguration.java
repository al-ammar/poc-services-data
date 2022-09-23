package ma.poc.configuration.datasource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("ma.poc.persistence.repository")
@EntityScan(basePackages = "ma.poc.persistence.entity")
@Configuration
public class PersitenceConfiguration {

// JCACH manager for second cash
//	@Bean
//	public HibernatePropertiesCustomizer hibernateSecondLevelCacheCustomizer(JCacheCacheManager cacheManager) {
//		return (properties) -> properties.put(ConfigSettings.CACHE_MANAGER, cacheManager.getCacheManager());
//	}

//    @Bean
//    @ConfigurationProperties("app.jpa")
//    public JpaProperties firstJpaProperties() {
//        return new JpaProperties();
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean firstEntityManagerFactory(DataSource firstDataSource,
//            JpaProperties firstJpaProperties) {
//        EntityManagerFactoryBuilder builder = createEntityManagerFactoryBuilder(firstJpaProperties);
//        return builder.dataSource(firstDataSource).packages(Order.class).persistenceUnit("firstDs").build();
//    }
//
//    private EntityManagerFactoryBuilder createEntityManagerFactoryBuilder(JpaProperties jpaProperties) {
//        JpaVendorAdapter jpaVendorAdapter = createJpaVendorAdapter(jpaProperties);
//        return new EntityManagerFactoryBuilder(jpaVendorAdapter, jpaProperties.getProperties(), null);
//    }
//
//    private JpaVendorAdapter createJpaVendorAdapter(JpaProperties jpaProperties) {
//        return new HibernateJpaVendorAdapter();
//    }
}
