package sayner.sandbox.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/*
 *
 */
public class WebAppInit implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		// ================================================
		// Now creating second, but java configured context
		// ================================================
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();

		// Registers annotated configurations class
		applicationContext.register(ApplicationContextConfiguration.class);

		ServletRegistration.Dynamic appDispatcher = container.addServlet("noxml-webapp",
				new DispatcherServlet(applicationContext));
		appDispatcher.setLoadOnStartup(1);
		appDispatcher.addMapping("/");
	}
}
