package com.nt.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nt.model.Actor;
@Repository("actorDAO")
public class ActorDAOImpl implements IActorDAO {
@Autowired
private	SimpleJdbcInsert sji;
	@Override
	public int insertSetRecord(Actor actor) {
	//set the table nane
		sji.setTableName("Actor");
		//execute and return value
		Map<String,Object> map=Map.of("ACTORID",actor.getACTORID(),
				
			"ACTORNAME",actor.getACTORNAME(),
			"ACTORADDRESS",actor.getACTORADDRESS(),
			"PHONENO",actor.getPHONENO(),
			"REMUNERATION",actor.getREMUNERATION());
		
			int count=sji.execute(map);
					return count;
	}

}
