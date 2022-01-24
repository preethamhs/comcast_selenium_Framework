package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Leads {
	
	private WebDriver driver;
	public Leads(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@title='Create Lead...']")
	private WebElement CreateNwLeadImg;
	
	public WebElement getCreateNwLeadImg() {
		return CreateNwLeadImg;
	}
	
	

}
