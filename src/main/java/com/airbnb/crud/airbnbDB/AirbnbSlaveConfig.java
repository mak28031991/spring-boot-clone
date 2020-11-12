package com.airbnb.crud.airbnbDB;

import com.airbnb.crud.airbnbDB.annotation.ReadOnlyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource({"classpath:application.properties"})
@EnableJpaRepositories(
        basePackages = "com.airbnb.crud.airbnbDB",
        includeFilters = @ComponentScan.Filter(ReadOnlyRepository.class),
        entityManagerFactoryRef = "airbnbSlaveEntityManager",
        transactionManagerRef = "airbnbSlaveTransactionManager"
)
@EnableTransactionManagement
public class AirbnbSlaveConfig {
    @Autowired
    public AirbnbSlaveConfig() {
        super();
    }

    @Bean("airbnbDataSlaveSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.airbnb-slave-datasource")
    public DataSource airbnbDataSlaveSource(){
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean airbnbSlaveEntityManager(@Qualifier("airbnbDataSlaveSource") final DataSource airbnbDataSlaveSource){
        HibernateJpaVendorAdapter vendorAdapter =new HibernateJpaVendorAdapter();
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(airbnbDataSlaveSource);
        em.setPackagesToScan("com.airbnb.crud.airbnbDB");
        em.setJpaVendorAdapter(vendorAdapter);
        Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.implicit_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy");
        properties.put("hibernate.physical_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy");
        em.setJpaPropertyMap(properties);
        return em;
    }

    public PlatformTransactionManager airbnbSlaveTransactionManager(@Qualifier("airbnbSlaveEntityManager") final LocalContainerEntityManagerFactoryBean airbnbSlaveEntityManager){
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(airbnbSlaveEntityManager.getObject());
        return transactionManager;
    }
}
