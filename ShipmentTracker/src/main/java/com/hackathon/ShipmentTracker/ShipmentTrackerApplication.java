package com.hackathon.ShipmentTracker;


import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class ShipmentTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShipmentTrackerApplication.class, args);
	}
	
	 @Bean
	    public DataSource getDBDataSource() {
	        final DriverManagerDataSource driverManagerDataSource
	                = new DriverManagerDataSource(
	                        "jdbc:oracle:thin:@//localhost:1521/xe",
	                        "stracker",
	                        "stracker"
	                );

	        driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	        return driverManagerDataSource;
	    }


	    @Bean
	    public JdbcTemplate getJdbcTemplate(final DataSource dataSource) {
	        return new JdbcTemplate(dataSource);
	    }
}
