package ml.work.demo.repository

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import javax.sql.DataSource


@Configuration
@ConfigurationPropertiesScan(basePackages = ["ml.work.demo"])
@EnableJpaRepositories("ml.work.demo")
@SpringBootApplication(scanBasePackages = ["ml.work.demo"])
class TestConfig {

    @Bean
    fun transactionManager(dataSource: DataSource) = DataSourceTransactionManager(dataSource)
}