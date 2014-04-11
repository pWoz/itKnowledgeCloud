package com.itKnowledgeCloud.util.appProperties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppProperties {

	private Properties properties;
	
	public AppProperties() {
		properties = new Properties();
	}
	
	public String get(String propertyKey){
		if(properties.get(propertyKey) != null)
			return properties.get(propertyKey).toString();
		else
			return null;
	}
	public void add(String propertyKey, String propertyValue){
		properties.setProperty(propertyKey, propertyValue);
	}
	public void load(InputStream inputStream) throws IOException{
		properties.load(inputStream);
	}
	
}
