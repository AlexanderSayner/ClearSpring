package sayner.sandbox.config;

/**
 * Using Servlet 3.x and a Java Application Context
 * Теоритически можно обойтись без этого класса, 
 * так как контекст инициализируется в классе WebAppInit implements WebApplicationInitializer,
 * с которого и начинается весь spring. 
 * Затем. в нём же прописывается класс с конфигом
 * 
 * 
 * @author uarchon
 *
 */
public class SpringMvcDispatcherServletInitializer{}/* extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {

    	return new Class[]{
                ApplicationContextConfiguration.class
        };      
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
    	
    	return null;
    }

    @Override
    protected String[] getServletMappings() {
    	
        return new String[]{
                "/"
        };
    }

}*/
