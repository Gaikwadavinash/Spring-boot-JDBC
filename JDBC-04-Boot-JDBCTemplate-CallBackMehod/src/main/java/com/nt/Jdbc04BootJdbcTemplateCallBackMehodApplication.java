package com.nt;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.nt.dto.EmployeeDTO;
import com.nt.service.IEmployeeMangService;
import com.zaxxer.hikari.HikariDataSource;

@SpringBootApplication
@ComponentScan(basePackages ="com.nt.service")
@ComponentScan(basePackages = "com.nt.dao")
public class Jdbc04BootJdbcTemplateCallBackMehodApplication {
	@Autowired
private Environment env;
	@Bean("hkds")
	public DataSource createDataSource() {
	HikariDataSource ds=  new HikariDataSource();
	ds.setDriverClassName(env.getRequiredProperty("spring.datasource.driver-class-name"));
	ds.setJdbcUrl(env.getRequiredProperty("spring.datasource.url"));
	ds.setUsername(env.getRequiredProperty("spring.datasource.username"));
	ds.setPassword(env.getRequiredProperty("spring.datasource.password"));
	return ds;
	}
	@Bean("jTemplate")
	public JdbcTemplate createdata() {
		return new JdbcTemplate(createDataSource());
	}
	
	public static void main(String[] args) {
ApplicationContext ctx=SpringApplication.run(Jdbc04BootJdbcTemplateCallBackMehodApplication.class, args);
	try {
IEmployeeMangService service=ctx.getBean("empService",IEmployeeMangService.class);
List<EmployeeDTO> DTO=service.fetchEmployeeByDesg("CLERK","MANAGER","SALESMAN");
DTO.forEach(System.out::println);		
	}catch(DataAccessException dae) {
		dae.printStackTrace();
	}
	
	}

}
