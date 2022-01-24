package com.crm.comcast.genericlibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	public String readDataFromProperty(String key) throws Throwable {
		FileInputStream fis=new FileInputStream("./data/commonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String propertydata = p.getProperty(key);
		return propertydata;
	}

}
