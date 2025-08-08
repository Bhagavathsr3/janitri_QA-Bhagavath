package com.janitri.Tests;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.janitri.Base.TestBase;
import com.janitri.Pages.LoginPage;

public class LoginTests extends TestBase{
	
	@Test
	public void testLoginButtonDisabledWhenFieldAreEmpty() {
		LoginPage lp = new LoginPage(driver);
		lp.testLoginButtonDisabledWhenFieldAreEmpty();
	}
	@Test
	public void testPasswordMaskedbutton() {
		LoginPage lp = new LoginPage(driver);
	    lp.testPasswordMaskedbutton();
	}
	@Test
	public void testInvalidLoginShowErrorMsg() {
		LoginPage lp = new LoginPage(driver);
        lp.login("Hello", "hii");
        String errorMessage = lp.getLoginErrormessage().getText();
        lp.logger.info("Displayed error message is "+errorMessage);
	}
	@Test
	public void testWithBlankFields() {
		LoginPage lp = new LoginPage(driver);
        lp.login("", "");
        String errorMessage = lp.getLoginErrormessage().getText();
        lp.logger.info("Displayed error message is "+errorMessage);
	}
}