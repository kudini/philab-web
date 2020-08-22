package pl.coderslab.philabweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

@SpringBootApplication(scanBasePackages = "pl.coderslab.philabweb")
@EnableJpaRepositories
public class PhilabWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhilabWebApplication.class, args);
    }

}
