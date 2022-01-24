package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformation {
	private WebDriver driver;
	public OrganizationInformation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgHeaderTxt;
	
	@FindBy(id="mouseArea_Industry")
	private WebElement IndustryTxt;
	
	public WebElement getOrgHeaderTxt() {
		return orgHeaderTxt;
	}

	public WebElement getIndustryTxt() {
		return IndustryTxt;
	}

}
