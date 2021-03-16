package com.hiberbabl.config;

import com.hiberbabl.service.StateBean;
import com.hiberbabl.service.SuperStateBean;
import com.hiberbabl.test.RequestHandler;
import com.hiberbabl.test.RequestManager;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"com.hiberbabl.dao", "com.hiberbabl.service"})
@EnableTransactionManagement
public class AppConfig {

  @Bean
  public DataSource dataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/hiberbabl?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false");
    dataSource.setUsername("root");
    dataSource.setPassword("89056515838q");
    System.out.println("kek");
    return dataSource;
  }

  private Properties hibernateProperties() {
    Properties hibernateProp = new Properties();
    hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
    hibernateProp.put("hibernate.format_sql", true);
    hibernateProp.put("hibernate.use_sql_comments", true);
    hibernateProp.put("hibernate.show_sql", true);
    hibernateProp.put("hibernate.hbm2ddl.auto", "create");
    hibernateProp.put("hibernate.max_fetch_depth", 3);
    hibernateProp.put("hibernate.jdbc.batch_size", 10);
    hibernateProp.put("hibernate.jdbcfetch_size", 50);
//    hibernateProp.put("hibernate.enable_lazy_load_no_trans", true);

    return hibernateProp;
  }

  @Bean
  public SessionFactory sessionFactory() throws IOException {
    LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
    sessionFactoryBean.setDataSource(dataSource());
    sessionFactoryBean.setPackagesToScan("com.hiberbabl.entity");
    sessionFactoryBean.setHibernateProperties(hibernateProperties());
    sessionFactoryBean.afterPropertiesSet();
    return sessionFactoryBean.getObject();
  }

  @Bean
  public PlatformTransactionManager transactionManager() throws IOException {
    return new HibernateTransactionManager(sessionFactory());
  }

  @Bean
  @Scope("prototype")
  public StateBean stateBean() {
    return new StateBean();
  }

  @Bean
  public SuperStateBean superStateBean() {
    SuperStateBean superStateBean = new SuperStateBean();
    superStateBean.setStateBean(stateBean());
    return superStateBean;
  }

  @Bean
  public RequestHandler requestHandler() {
    return new RequestHandler();
  }

  @Bean
  public RequestManager requestManager() {
    return new RequestManager();
  }

}
