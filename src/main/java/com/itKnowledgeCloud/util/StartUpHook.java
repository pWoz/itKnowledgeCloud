package com.itKnowledgeCloud.util;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import com.itKnowledgeCloud.util.db.DbMigrator;

@Singleton
@Startup
public class StartUpHook {
	
	@Inject
	private DbMigrator dbMigrator;
	
	@PostConstruct
	public void executeStartUpTasks(){
		dbMigrator.migrate();
	}
}
