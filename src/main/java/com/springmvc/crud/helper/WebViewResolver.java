package com.springmvc.crud.helper;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.springmvc.crud")
class WebViewResolver implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver getResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
        return resolver;
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource data = new DriverManagerDataSource();
        data.setDriverClassName("com.mysql.cj.jdbc.Driver");
        data.setUrl("jdbc:mysql://localhost:3306/spring_mvc");
        data.setUsername("root");
        data.setPassword("1234");
        return data;
    }

    @Bean
    public Properties getProps() {
        Properties props = new Properties();
        props.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        props.put("hibernate.hbm2ddl.auto", "update");
        props.put("hibernate.show_sql", true);
        props.put("hibernate.format_sql", true);
        return props;
    }

    @Bean
    public LocalSessionFactoryBean getFactory() {
        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
        factory.setDataSource(getDataSource());
        factory.setHibernateProperties(getProps());
        factory.setPackagesToScan("com.springmvc.crud.entity");
        return factory;
    }

    @Bean
    public HibernateTemplate getTemplate() {
        return new HibernateTemplate(getFactory().getObject());
    }

    @Bean
    public HibernateTransactionManager getManager() {
        return new HibernateTransactionManager(getFactory().getObject());
    }

}
