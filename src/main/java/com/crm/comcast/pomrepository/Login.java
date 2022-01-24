package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	@FindBy(name="user_name")
	private WebElement userNameTbx;
	
	@FindBy(name="user_password")
	private WebElement passwordTbx;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;

	private WebDriver driver;
	
	public Login(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void LoginToApp(String username,String password) {
		userNameTbx.sendKeys(username);
		passwordTbx.sendKeys(password);
		loginBtn.click();	
	}

}
