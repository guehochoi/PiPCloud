package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import support.KnowsTheDomain;

@Configuration
public class TestConfiguration {
	@Bean
	public static KnowsTheDomain knowsTheDomain() {
		return new KnowsTheDomain();
	}
}
