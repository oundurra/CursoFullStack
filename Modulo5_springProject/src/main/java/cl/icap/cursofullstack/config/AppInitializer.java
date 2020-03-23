package cl.icap.cursofullstack.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import cl.icap.cursofullstack.Modulo5SpringProjectApplication;

public class AppInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Modulo5SpringProjectApplication.class);
	}

}