package com.crm.comcast.pomrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganization {
	private WebDriver driver;
	public CreateNewOrganization(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement orgNameTbx;
	
	@FindBy(name="industry")
	private WebElement industyDrpdwn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	public void createOrg(String orgName) throws InterruptedException 
	{
	orgNameTbx.sendKeys(orgName);
	saveBtn.click();
		
	}
	public void createOrg(String orgName,String industries ) 
	{
	orgNameTbx.sendKeys(orgName);
	industyDrpdwn.sendKeys(industries); 
	saveBtn.click();
	
		
	}
	
	public WebElement getOrgNameTbx() {
		return orgNameTbx;
	}
	public WebElement getIndustyDrpdwn() {
		return industyDrpdwn;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	

}
