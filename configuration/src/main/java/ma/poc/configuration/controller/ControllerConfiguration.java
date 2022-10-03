package ma.poc.configuration.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@Configuration
@ComponentScan(value = "ma.poc.controller")
public class ControllerConfiguration {
	
//	@Bean(name = "multipartResolver")
//	public CommonsMultipartResolver multipartResolver() {
//	    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//	    multipartResolver.setMaxUploadSize(500000);
//	    return multipartResolver;
//	}
	
	@Bean
    public MultipartResolver multipartResolver() {
         StandardServletMultipartResolver s = new StandardServletMultipartResolver();
         return s;
    }
}
