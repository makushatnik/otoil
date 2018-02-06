package com.otoil.ot_118_rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.sql.DataSource;

/**
 * Created by Ageev Evgeny on 02.02.2018.
 */
@Configuration
public class SpringConfig {

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @Bean(name = "dataSource")
    @Primary
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        dataSource.setUsername("sys");
        dataSource.setPassword("WeRfV234$");
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        return dataSource;
    }

    @Profile("test")
    @Bean
    public DataSource embeddedDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema.sql")
                .addScript("classpath:test-data.sql")
                .build();
    }

    @Profile("qa")
    @Bean
    public DataSource dataSource() {
        SingleConnectionDataSource ds = new SingleConnectionDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:tcp://localhost/-/otoil");
        ds.setUsername("tom");
        ds.setPassword("cat");
        return ds;
    }

    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(getDataSource());
    }
}
