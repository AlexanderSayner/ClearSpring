package sayner.sandbox.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Using Servlet 3.x and a Java Application Context
 * @author uarchon
 *
 */
public class SpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
    	
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
    	
        return new Class[]{
                ApplicationContextConfiguration.class
        };
    }

    @Override
    protected String[] getServletMappings() {
    	
        return new String[]{
                "/"
        };
    }

}
