package com.itKnowledgeCloud.services;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;

import com.itKnowledgeCloud.ejb.UsersBean;

public class UserAccountsGenerator{

	@Resource(lookup = "java:comp/DefaultManagedExecutorService")  
	private ManagedExecutorService executorService;
	
	@Inject
	private UsersBean usersBean;
	
	@Inject
	private Logger log;
	
	public void generate(UserAccountsGeneratorProperties properties){
		log.info("Creating workers");
		UserAccountsGeneratorWorker worker = new UserAccountsGeneratorWorker(usersBean);
		UserAccountsGeneratorWorker worker1 = new UserAccountsGeneratorWorker(usersBean);
		UserAccountsGeneratorWorker worker2 = new UserAccountsGeneratorWorker(usersBean);
		log.info("Executing workers");
		executorService.execute(worker);
		executorService.execute(worker1);
		executorService.execute(worker2);
	}
}
