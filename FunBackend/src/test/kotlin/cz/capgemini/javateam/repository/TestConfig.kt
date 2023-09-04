package cz.capgemini.javateam.repository

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import javax.sql.DataSource


@Configuration
@ConfigurationPropertiesScan(basePackages = ["cz.capgemini.javateam"])
@EnableJpaRepositories("cz.capgemini.javateam")
@SpringBootApplication(scanBasePackages = ["cz.capgemini.javateam"])
class TestConfig {

    @Bean
    fun transactionManager(dataSource: DataSource) = DataSourceTransactionManager(dataSource)
}