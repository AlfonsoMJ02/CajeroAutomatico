package CajeroAutomatico.Configuration;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource dataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        dataSource.setUsername("AMorenoCajeroAutomatico");
        dataSource.setPassword("password1");

        return dataSource;
    }
}
