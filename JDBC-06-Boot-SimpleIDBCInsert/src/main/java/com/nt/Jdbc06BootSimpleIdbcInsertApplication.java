package com.nt;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.nt.model.Actor;
import com.nt.sevcie.IActorMangService;

@SpringBootApplication
public class Jdbc06BootSimpleIdbcInsertApplication {
	
	
@Autowired
private DataSource ds;
	
@Bean("sji")
public SimpleJdbcInsert insert() {
	return  new SimpleJdbcInsert(ds);
}
	
	
	
	public static void main(String[] args) {
//create Ioc Conatiner
		ApplicationContext ctx=SpringApplication.run(Jdbc06BootSimpleIdbcInsertApplication.class, args);
	//target Class
IActorMangService service=ctx.getBean("actorService",IActorMangService.class);
try {
Actor actor= new Actor();	
	actor.setACTORID(1007);
	actor.setACTORNAME("Karishma");
	actor.setACTORADDRESS("Mumbai");
	actor.setPHONENO(54554L);
	actor.setREMUNERATION(3131.0f);
String Result=service.setRecord(actor);
System.out.println(Result);
}catch(DataAccessException ad) {
	ad.printStackTrace();
}
	}

}
