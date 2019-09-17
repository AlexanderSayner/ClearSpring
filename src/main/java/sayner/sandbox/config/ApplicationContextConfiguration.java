package sayner.sandbox.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import sayner.sandbox.models.HelloWorld;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"sayner.sandbox"})
public class ApplicationContextConfiguration implements WebMvcConfigurer {
	
	// Hello bean
	@Bean 
	   public HelloWorld helloWorld(){
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
	
}
