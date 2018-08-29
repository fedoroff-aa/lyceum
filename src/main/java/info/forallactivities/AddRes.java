package info.forallactivities;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class AddRes extends WebMvcConfigurerAdapter{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/webres/css/**").addResourceLocations("/webres/css/");
		registry.addResourceHandler("/webres/img/**").addResourceLocations("/webres/img/");
		registry.addResourceHandler("/webres/js/**").addResourceLocations("/webres/js/");
		registry.addResourceHandler("/pages/articles/**").addResourceLocations("/pages/articles/");
	}
	
}
