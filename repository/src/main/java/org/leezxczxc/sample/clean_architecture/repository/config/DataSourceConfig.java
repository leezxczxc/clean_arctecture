package org.leezxczxc.sample.clean_architecture.repository.config;

import com.zaxxer.hikari.HikariDataSource;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by OGQ Corp. User: iseheon Created At: 2020/08/05 4:18 오후 Last Modified At: 2020/08/05
 */
@Configuration
public class DataSourceConfig {


  public static final String ACCOUNT_TRANSACTION_MANAGER = "accountTransactionManager";

  @Bean
  public JpaDialect jpaDialect() {
    return new HibernateJpaDialect();
  }

  @Primary
  @Bean("accountDataSource")
  @ConfigurationProperties("datasource.account")
  public HikariDataSource accountDataSource () {
    return DataSourceBuilder.create().type(HikariDataSource.class).build();
  }

  @Primary
  @Bean(name = "accountEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean accountEntityManagerFactory(
      EntityManagerFactoryBuilder builder) {
    LocalContainerEntityManagerFactoryBean factoryBean = builder
        .dataSource(accountDataSource())
        .packages("org.leezxczxc.sample.clean_architecture.domain")
        .persistenceUnit("account")
        .build();
    Map<String, String> properties = new HashMap<>();
    properties.put("hibernate.jdbc.time_zone ", "UTC");
    factoryBean.setJpaPropertyMap(properties);
    factoryBean.setJpaDialect(jpaDialect());
    return factoryBean;
  }

  @Primary
  @Bean(ACCOUNT_TRANSACTION_MANAGER)
  public PlatformTransactionManager accountTransactionManager(@Qualifier("accountEntityManagerFactory") LocalContainerEntityManagerFactoryBean bean) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(bean.getObject());
    return transactionManager;
  }

  @Primary
  @Bean("accountTransactionTemplate")
  public TransactionTemplate accountTransactionTemplate(@Qualifier("accountTransactionManager") @Autowired PlatformTransactionManager transactionManager) {
    return new TransactionTemplate(transactionManager);
  }

  @Configuration
  @EnableJpaRepositories(
      basePackages = {"org.leezxczxc.sample.clean_architecture.repository"},
      entityManagerFactoryRef = "accountEntityManagerFactory",
      transactionManagerRef = "accountTransactionManager"
  )
  public static class accountConfiguration {}

}
