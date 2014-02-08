package com.itKnowledgeCloud.util.db;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.googlecode.flyway.core.Flyway;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class DbMigrator {

	//@Resource(name = "java:jboss/datasources/itKnowledgeCloudDS")
	//@Resource(name = "java:comp/DefaultDataSource")
	//private DataSource dataSource;
	
	@Inject
	private Logger logger;
	
	public void migrate(){
		DataSource dataSource = null;
		try {
			//temporary because of jbas011053
			InitialContext ctx = new InitialContext();
			Object obj = ctx.lookup("java:jboss/datasources/itKnowledgeCloudDS");
			dataSource = (DataSource)obj;
			System.out.println("obj"+obj);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("Start DB migration");
		Flyway flyway = new Flyway();
		flyway.setInitOnMigrate(true);
		flyway.setDataSource(dataSource);
		flyway.migrate();
		logger.info("DB migration finished");
	}
}
