package com.crm.comcast.pomrepository;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewLead {
	
	private WebDriver driver;
	public CreateNewLead(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastNameTbx;
	
	@FindBy(name="company")
	private WebElement companyTbx;
	
	@FindBy(name="annualrevenue")
	private WebElement annualRevenueTbx;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	 private WebElement saveBtn;
	
	public void createLeadAnnualRevenue(String lastName,String company,String annualRevenue) {
		lastNameTbx.sendKeys(lastName);
		companyTbx.sendKeys(company);
		annualRevenueTbx.sendKeys(annualRevenue);
		saveBtn.click();
	}

	public WebElement getLastNameTbx() {
		return lastNameTbx;
	}

	public WebElement getCompanyTbx() {
		return companyTbx;
	}

	public WebElement getAnnualRevenueTbx() {
		return annualRevenueTbx;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	

}
