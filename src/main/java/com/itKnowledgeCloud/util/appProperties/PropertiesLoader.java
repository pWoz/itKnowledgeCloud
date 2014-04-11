package com.itKnowledgeCloud.util.appProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

public class PropertiesLoader {

	@Inject
	private Logger log;
	
	private static final String PROPERTIES_FILE_NAME = "app.properties";
	@Produces
	@ApplicationScoped
	@Properties
	public AppProperties generatePropertiesObject(){
		log.info("Loading app properties file");
		AppProperties props = new AppProperties();
		//
		try {
			InputStream propertiesFileStream = new FileInputStream(getFilePath());
			props.load(propertiesFileStream);
			log.info("Loading app properties file finished");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("App Properties file not found!!");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("App Properties file load error!!");
		}
		return props;
	}
	
	private String getFilePath(){
		String userHome = System.getProperty("user.home");
		String separator = System.getProperty("file.separator");
		return userHome+separator+PROPERTIES_FILE_NAME;
	}
}
