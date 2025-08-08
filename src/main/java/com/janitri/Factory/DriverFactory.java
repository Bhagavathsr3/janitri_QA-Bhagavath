package com.janitri.Factory;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.janitri.Config.ConfigReader;
import com.janitri.enums.BrowserType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

private static ThreadLocal<WebDriver>  tldriver = new ThreadLocal<WebDriver>();

public static void initDriver() {
	String browserValue = ConfigReader.getKeyValue("browser").toUpperCase();
	BrowserType browser = BrowserType.valueOf(browserValue);
	
	switch(browser) {
	case CHROME:
		// Set up WebDriverManager
	    WebDriverManager.chromedriver().setup();

	    // Create preferences map
	    HashMap<String, Object> prefs = new HashMap<>();
	    prefs.put("profile.default_content_setting_values.notifications", 1); // 1 = Allow

	    // Create ChromeOptions and set preferences
	    ChromeOptions options = new ChromeOptions();
	    options.setExperimentalOption("prefs", prefs);
	  
	    // Set ThreadLocal WebDriver instance with options
	    tldriver.set(new ChromeDriver(options));
		break;
	case FIREFOX:
		WebDriverManager.firefoxdriver().setup();
		tldriver.set(new FirefoxDriver());
		break;
	case EDGE:
		WebDriverManager.edgedriver().setup();
		tldriver.set(new EdgeDriver());
		break;
	
	}
	
}
public static WebDriver getDriver() {
	return tldriver.get();
}
}
