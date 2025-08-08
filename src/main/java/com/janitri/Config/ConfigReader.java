package com.janitri.Config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties prop;
	public static void loadConfig(String env) throws IOException {
		
		File file = new File("src/main/resources/"+env+".Properties"); // to load the file
		
		FileInputStream fis = new FileInputStream(file); // to read the file
		
		 prop = new Properties(); // create a empty object memory to hold config data
		
		prop.load(fis); // read the key value par in .prop file
	}
	
// Method to call the key value 
	public static String getKeyValue(String key) {
		String value = prop.getProperty(key);
		return value;
	}
}
