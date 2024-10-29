package com.example.atm_monitoring_api;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
@ComponentScan(basePackages = {"com.example.atm_monitoring_api.filters"})
public class AtmMonitoringApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtmMonitoringApiApplication.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(AtmMonitoringApiApplication.class, args);
		if (context.containsBean("beanInvoker")) {
			((ConfigurableListableBeanFactory) context.getBeanFactory()).destroyBean("beanInvoker");
		}
	}

}
