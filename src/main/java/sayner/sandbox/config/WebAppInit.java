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
 * Конфигурирует контекст приложения, запускает Dispetcher Servlet
 */
public class WebAppInit implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {

		// Объявление контекста 
		XmlWebApplicationContext xmlContext = new XmlWebApplicationContext();

		// Указать файл с конфигурацией контекста
		xmlContext.setConfigLocation("/WEB-INF/application-context.xml");

		// Finally, we create a ContextLoaderListener with the root context and register
		// it
		// with the servlet container. As we can see, ContextLoaderListener has an
		// appropriate constructor
		// that takes a WebApplicationContext and makes it available to the application:
		container.addListener(new ContextLoaderListener(xmlContext));

		ServletRegistration.Dynamic xmlDispatcher = container.addServlet("xml-webapp",
				new DispatcherServlet(xmlContext));
		xmlDispatcher.setLoadOnStartup(1);

		// Не работает /*
		xmlDispatcher.addMapping("/xml", "/xml/*", "/xml*/**", "/xml/hi");

		// ================================================
		// Now creating second, but java configured context
		// ================================================
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();

		// Registers annotated configurations class
		applicationContext.register(ApplicationContextConfiguration.class);

		// Зачем это делать, когда есть аннотация @ComponentScan в подключённом строчкой
		// выше классе с конфигом
		// applicationContext.scan("sayner.sandbox.context.annotated");

		ServletRegistration.Dynamic appDispatcher = container.addServlet("noxml-webapp",
				new DispatcherServlet(applicationContext));
		appDispatcher.setLoadOnStartup(1);
		appDispatcher.addMapping("/");
	}
}
