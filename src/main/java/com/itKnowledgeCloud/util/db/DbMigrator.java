package com.itKnowledgeCloud.util.db;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.sql.DataSource;

import com.googlecode.flyway.core.Flyway;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class DbMigrator {

	@Resource(name = "java:comp/DefaultDataSource")
	private DataSource dataSource;
	
	@Inject
	private Logger logger;
	
	public void migrate(){
		logger.info("Start DB migration");
		Flyway flyway = new Flyway();
		flyway.setInitOnMigrate(true);
		flyway.setDataSource(dataSource);
		flyway.migrate();
		logger.info("DB migration finished");
	}
}
