package uk.karlovich.mountains;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfiguration {

	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${spring.datasource.username}")
	private String username;
		
	@Value("${spring.datasource.password}")
	private String password;
		
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;
	
	public String getUrl() {
		return this.url;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getDriverClassName() {
		return this.driverClassName;
	}
	
}
