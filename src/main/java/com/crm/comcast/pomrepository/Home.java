package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericlibrary.WebDriverUtility;

public class Home extends WebDriverUtility {
	
	private WebDriver driver;
	public Home(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Leads")
	private WebElement LeadLnk;
	
	@FindBy(linkText="Organizations")
	private WebElement orgLnk;
	
	@FindBy(linkText="Contacts") // xpath="//a[text()='Contacts']"
	private WebElement contactLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstnImg;
	
	@FindBy(linkText="Sign Out") //xpath="//a[.='Sign Out']"
	private WebElement signoutLnk;
	
	public void logout() {
		Actions a=new Actions(driver);
		a.moveToElement(adminstnImg).perform();
		signoutLnk.click();
	}

	public WebElement getOrgLnk() {
		return orgLnk;
	}

	public WebElement getContactLnk() {
		return contactLnk;
	}

	public WebElement getAdminstnImg() {
		return adminstnImg;
	}

	public WebElement getSignoutLnk() {
		return signoutLnk;
	}

	public WebElement getLeadLnk() {
		return LeadLnk;
	}
	
	

}
