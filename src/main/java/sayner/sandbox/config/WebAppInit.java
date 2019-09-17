package sayner.sandbox.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInit implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {

		// Creating xml context
		XmlWebApplicationContext applicationContext=new XmlWebApplicationContext();
		applicationContext.setConfigLocation("/WEB-INF/application-context.xml");
		ServletRegistration.Dynamic xmlDispatcher = container.addServlet("xml", new DispatcherServlet(applicationContext));
		xmlDispatcher.setLoadOnStartup(1);
		xmlDispatcher.addMapping("/xml");
		
		// Creates context object
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

		// Registers annotated configurations class
		context.register(ApplicationContextConfiguration.class);

		context.scan("sayner.sandbox");

		// Finally, we create a ContextLoaderListener with the root context and register it 
		// with the servlet container. As we can see, ContextLoaderListener has an appropriate constructor
		// that takes a WebApplicationContext and makes it available to the application:
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
