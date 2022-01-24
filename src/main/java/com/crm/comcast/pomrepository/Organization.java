package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization {
	
	private WebDriver driver;
	public Organization(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createNwOrgImg;
	
	@FindBy(name="search_text")
	private WebElement searchTbx;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	public WebElement getCreateNwOrgImg() {
		return createNwOrgImg;
	}

	public WebElement getSearchTbx() {
		return searchTbx;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	
		
	

}
