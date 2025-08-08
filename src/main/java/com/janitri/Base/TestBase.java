package com.janitri.Base;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.janitri.Config.ConfigReader;
import com.janitri.Factory.DriverFactory;

public class TestBase {
	protected static WebDriver driver;
	
@BeforeMethod
	public void setup() throws IOException {
	   
		ConfigReader.loadConfig("prod"); // .properties file is now loaded
		DriverFactory.initDriver();
	    driver= DriverFactory.getDriver();    
	    driver.get(ConfigReader.getKeyValue("url"));
		driver.manage().window().maximize();
		
	}
@AfterMethod
public void taerdown() {
	driver.quit();
}
}
