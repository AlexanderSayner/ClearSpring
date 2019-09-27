/**
 * 
 */
package sayner.sandbox.context.annotated.models;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * Экспериментальный класс для проверки скоупа бинов
 * 
 * ConfigurableBeanFactory.SCOPE_SINGLETON - бин будет создан единожды при
 * старте, затем только используется по мере выполнения приложения
 * 
 * ConfigurableBeanFactory.SCOPE_PROTOTYPE - бин создаётся заново каждый раз при
 * вызове getBean из контекста.
 * 
 * ConfigurableBeanFactory не зависит от текущей сессии. Если в одной сессии бин
 * изменится, то он же изменится и в другой
 * 
 * WebApplicationContext.SCOPE_REQUEST - работает как синглтон, но для каждого
 * запроса отдельно: бин создаётся при выполнении запроса, уничтожается по его
 * завершении
 * 
 * WebApplicationContext.SCOPE_SESSION - синглтон для каждой сессии персонально
 * (в разных браузерах свой синглтон, но в отличии от ConfigurableBeanFactory
 * при изменении бина в одной сессии, он же не изменится в другой
 * 
 * WebApplicationContext.SCOPE_APPLICATION - теперь это синглтон для каждого
 * контекста персонально: если этот же бин создать в параллельном xml контексте,
 * но на нём не скажутся изменения, сделанные в данном контексте (независимость
 * по контексту)
 * 
 * scopeName = "websocket" - синглтон для веб-сокета отдельно
 * 
 * @author uarchon
 * 
 */
@Component("personBean")
//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Person implements DisposableBean, InitializingBean {

	@Value("${person.name}")
	private String name;

	public Person() {
		System.out.println("Constructor of person bean is invoked!");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Initializing method of person bean is invoked!");
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Destroy method of person bean is invoked!");
	}

}
