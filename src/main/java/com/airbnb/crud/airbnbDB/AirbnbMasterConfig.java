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
        excludeFilters = @ComponentScan.Filter(ReadOnlyRepository.class),
        entityManagerFactoryRef = "airbnbMasterEntityManager",
        transactionManagerRef = "airbnbMasterTransactionManager"
)
@EnableTransactionManagement
public class AirbnbMasterConfig {

    @Autowired
    public AirbnbMasterConfig() {
        super();
    }

    @Bean("airbnbDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.airbnb-master-datasource")
    public DataSource airbnbDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean airbnbMasterEntityManager(@Qualifier("airbnbDataSource") final DataSource airbnbDataSource){
        HibernateJpaVendorAdapter vendorAdapter =new HibernateJpaVendorAdapter();
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(airbnbDataSource);
        em.setPackagesToScan("com.airbnb.crud.airbnbDB");
        em.setJpaVendorAdapter(vendorAdapter);
        Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.implicit_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy");
        properties.put("hibernate.physical_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy");
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Primary
    @Bean
    public PlatformTransactionManager airbnbMasterTransactionManager(@Qualifier("airbnbMasterEntityManager") final LocalContainerEntityManagerFactoryBean airbnbMasterEntityManager){
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(airbnbMasterEntityManager.getObject());
        return transactionManager;
    }
}
