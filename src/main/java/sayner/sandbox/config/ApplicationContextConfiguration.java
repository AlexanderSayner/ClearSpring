package sayner.sandbox.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import sayner.sandbox.models.HelloWorld;

/**
 * Простой класс конфигурации контекста Наследует интерфейс WebMvcConfigurer с
 * базовой настройкой Spring MVC
 * 
 * @author uarchon
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "sayner.sandbox.context.annotated" })
public class ApplicationContextConfiguration implements WebMvcConfigurer {
	
	// Hello bean
	@Bean(name = "helloBean")
	public HelloWorld helloWorld() {
		return new HelloWorld();
	}

	// Прописывается путь к java server page
	@Bean
	public InternalResourceViewResolver resolver() {

		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
            .addResourceHandler("/resources/**")
            .addResourceLocations("/resources/");
    }

}
