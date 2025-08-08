package com.janitri.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.janitri.utils.ActionUtils;
import com.janitri.utils.WaitUtils;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver tldriver) {
		super(tldriver);
		
	}
@FindBy(xpath = "//*[@id='formEmail']")
private WebElement userIdInput;

@FindBy(xpath = "//*[@id='formPassword']")
private WebElement passwordInput;
@FindBy(className  = "passowrd-visible")
private WebElement toggleBtn;
@FindBy(xpath = "//*[text()='Log In']")
private WebElement loginBtn;

@FindBy(className = "normal-text")
private WebElement loginErrormessage;


public WebElement getLoginErrormessage() {
	return loginErrormessage;
}



public void testLoginButtonDisabledWhenFieldAreEmpty() {
	boolean enabled = loginBtn.isEnabled();
	//Assert.assertEquals(enabled, false);
	if (! enabled) {
		logger.info("PASS : Login Button is not enabled");
	}
	else {
		logger.error("FAIL: Login button is enabled when fields are empty");
		Assert.fail("FAIL: Login button is enabled when fields are empty");
	}
}

public void testPasswordMaskedbutton()  {
	String attributeValue1 = toggleBtn.getAttribute("alt");
	logger.info("Before Clicking ToggleBtn :"+ attributeValue1);
	toggleBtn.click();
	String attributeValue2 = toggleBtn.getAttribute("alt");
	logger.info("After Clicking ToggleBtn :"+ attributeValue2);
	Assert.assertEquals(attributeValue2, " Password Visible");
}


public void login(String username, String password) {
	
	userIdInput.sendKeys(username);
	passwordInput.sendKeys(password);
	WaitUtils.waitUntilClickable(loginBtn);
	loginBtn.click();
}
}
