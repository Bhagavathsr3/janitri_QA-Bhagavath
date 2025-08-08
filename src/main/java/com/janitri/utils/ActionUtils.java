package com.janitri.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.janitri.Base.TestBase;

public class ActionUtils extends TestBase {

	public static void dropdownByVisibleText(WebElement element, String visisbleText) {
		
		
		//WebElement ele = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		select.selectByVisibleText(visisbleText);
		
	}
}
