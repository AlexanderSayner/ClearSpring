package sayner.sandbox.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = { "sayner.sandbox" })
public class WebMvcConfig/* implements WebMvcConfigurer */{
/*
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {

		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {

		registry.addViewController("/login").setViewName("login");
	}

	/*
	 * <bean
	 * class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	 * <property name="prefix"> <value>/WEB-INF/pages/</value> </property> <property
	 * name="suffix"> <value>.jsp</value> </property> </bean>
	 */
	
	/*
	@Bean
	public InternalResourceViewResolver setupViewResolver() {

		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		resolver.setViewClass(JstlView.class);

		return resolver;
	}
*/
}
