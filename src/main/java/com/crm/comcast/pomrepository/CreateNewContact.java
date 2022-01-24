package com.crm.comcast.pomrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericlibrary.WebDriverUtility;

public class CreateNewContact extends WebDriverUtility {
	 
	private WebDriver driver;
	
	public CreateNewContact(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastNameTbx;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	 private WebElement saveBtn;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	 private WebElement orgLookUpImg;
	
	public void createContact(String contactLastName) {
		lastNameTbx.sendKeys(contactLastName);
		saveBtn.click();
	}
   
	public void createContact(String contactLastName,String orgName) throws InterruptedException {
		lastNameTbx.sendKeys(contactLastName);
		orgLookUpImg.click();
		switchToWindow(driver,"Accounts&action");
		impWaitForPage(driver);
		Organization op=new Organization(driver);
		op.getSearchTbx().sendKeys(orgName);
		op.getSearchBtn().click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver,"Contacts&action");// //a[@href='javascript:window.close();]
		saveBtn.click();//
	}//
	//public void createContact(String contactLastName,String orgName) {
		
	//}

	public WebElement getLastNameEdt() {
		return lastNameTbx;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getOrgLookUpImg() {
		return orgLookUpImg;
	}
	

}
