package com.itKnowledgeCloud.controller;

import java.util.logging.Logger;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.itKnowledgeCloud.services.UserAccountsGenerator;
import com.itKnowledgeCloud.services.UserAccountsGeneratorProperties;

@Model
public class UserAccountsGeneratorController {

	@Inject
	private Logger log;
	
	@Inject
	private UserAccountsGenerator generator;
	
	public void generateAccounts(){
		log.info("User accounts generation start");
		UserAccountsGeneratorProperties generationProperties = new UserAccountsGeneratorProperties();
		generator.generate(generationProperties);
		log.info("User accounts generation task sent to generator");
	}
}
