package com.nt.sevcie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IActorDAO;
import com.nt.model.Actor;
@Service("actorService")
public class ActorManagServiceImpl implements IActorMangService {
@Autowired
private IActorDAO dao;	

	public String setRecord(Actor actor) {
	//get dao
		int count=dao.insertSetRecord(actor);
		return count==0?"Record are Not Inserted":"Record are Inserted"+actor;
	}

}
