/**
 * 
 */
package com.sivalabs.springjsfjpa.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Siva
 *
 */
@Configuration
@ComponentScan(basePackages="com.sivalabs.springjsfjpa")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.sivalabs.springjsfjpa.repositories" })
@PropertySource("classpath:application.properties")
public class AppConfig 
{
	
	@Autowired
	private Environment env;
	@Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer()
    {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource)
    {
        EntityManagerFactory factory = entityManagerFactory(dataSource).getObject();
        return new JpaTransactionManager(factory);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource)
    {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(Boolean.TRUE);
        vendorAdapter.setShowSql(Boolean.TRUE);

        factory.setDataSource(dataSource);
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.sivalabs.springjsfjpa.entities");

        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        factory.setJpaProperties(jpaProperties);

        factory.afterPropertiesSet();
        factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
        return factory;
    }

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator()
    {
        return new HibernateExceptionTranslator();
    }
    
    @Bean
    public DataSourceInitializer dataSourceInitializer(DataSource dataSource) 
    {
        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        String dbInitializationEnabled = env.resolvePlaceholders("${jdbc.init-db}");
        dataSourceInitializer.setEnabled(Boolean.parseBoolean(dbInitializationEnabled));
        dataSourceInitializer.setDataSource(dataSource);
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        String dbInitScriptLocation = env.resolvePlaceholders("${jdbc.initLocation}");
        if(StringUtils.isNotEmpty(dbInitScriptLocation))
        {
            databasePopulator.setScripts(new Resource[]{
                    new ClassPathResource(dbInitScriptLocation)
            });
        }
        dataSourceInitializer.setDatabasePopulator(databasePopulator);
        return dataSourceInitializer;
    }
    
   	@Bean
   	public DataSource dataSource()
   	{
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName(env.resolvePlaceholders("${jdbc.driverClassName}"));
      dataSource.setUrl(env.resolvePlaceholders("${jdbc.url}"));
      dataSource.setUsername(env.resolvePlaceholders("${jdbc.username}"));
      dataSource.setPassword(env.resolvePlaceholders("${jdbc.password}"));
      return dataSource;
    }
   	
   	
   	
   	
   	

}
