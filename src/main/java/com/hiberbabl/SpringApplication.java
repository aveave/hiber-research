package com.hiberbabl;

import com.hiberbabl.service.StateBean;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hiberbabl.config.AppConfig;

public class SpringApplication {

  @Autowired
  private SessionFactory sessionFactory;

  public static void main(String[] args) {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    applicationContext.getBean(StateBean.class);

  }
}
