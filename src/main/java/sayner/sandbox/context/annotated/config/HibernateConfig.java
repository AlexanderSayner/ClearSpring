/**
 * 
 */
package sayner.sandbox.context.annotated.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author uarchon
 * 
 *
 */
@Configuration
@EnableTransactionManagement // enables Spring’s annotation-driven transaction management capability.
@PropertySources({ @PropertySource(value = "classpath:database.properties") })
public class HibernateConfig {

	private final Environment environment;

	/**
	 * @param context
	 */
	@Autowired
	public HibernateConfig(Environment environment) {

		this.environment = environment;
	}

	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
		return dataSource;
	}

	@Bean
	public Properties hibernateProperties() {

		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		return properties;
	}

	/**
	 * LocalSessionFactoryBean creates a Hibernate SessionFactory. This is the usual
	 * way to set up a shared Hibernate SessionFactory in a Spring application
	 * context.
	 * 
	 * @return
	 */
	@Bean
	public LocalSessionFactoryBean sessionFactory() {

		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "sayner.sandbox.models" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	/**
	 * HibernateTransactionManager binds a Hibernate Session from the specified
	 * factory to the thread, potentially allowing for one thread-bound Session per
	 * factory. This transaction manager is appropriate for applications that use a
	 * single Hibernate SessionFactory for transactional data access, but it also
	 * supports direct DataSource access within a transaction i.e. plain JDBC.
	 * 
	 * @return
	 */
	@Bean
	public HibernateTransactionManager getTransactionManager() {

		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
}
