package com.janitri.Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	public static Logger logger;
	WebDriver tldriver;
	
	public BasePage(WebDriver tldriver) {
		 logger = LogManager.getLogger(this.getClass());
		this.tldriver=tldriver;
		PageFactory.initElements(tldriver, this);
	}
}
