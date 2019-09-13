package sayner.sandbox.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {

		// Creates context object
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

		// Registers annotated configurations class
		context.register(WebMvcConfig.class);

		context.scan("sayner.sandbox");

		// Sets ContextLoaderListener to servletContext
		container.addListener(new ContextLoaderListener(context));

		// Passes servlet context to context instance
		context.setServletContext(container);

		// Registers dispatch servlet and passes context instance
		ServletRegistration.Dynamic dispatcher = container.addServlet("mvc", new DispatcherServlet(context));

		// Sets creation priority
		dispatcher.setLoadOnStartup(1);

		// Maps URL pattern
		dispatcher.addMapping("/");
		/*
		 * //Registers security filters FilterRegistration.Dynamic security =
		 * servletContext.addFilter("springSecurityFilterChain", new
		 * DelegatingFilterProxy());
		 * 
		 * // Sets dispatcher types a security filters to be applied
		 * EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.REQUEST,
		 * DispatcherType.FORWARD); security.addMappingForUrlPatterns(dispatcherTypes,
		 * true, "/*");
		 */
	}
}
