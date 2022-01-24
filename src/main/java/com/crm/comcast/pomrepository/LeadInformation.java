package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadInformation {
	private WebDriver driver;
	public LeadInformation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="(//td[@class='dvtCellInfo' ])[2]")
	private WebElement leadNoSuchMsg;
	public WebElement getLeadNoSuchMsgSuchMsg() {
		return leadNoSuchMsg;
	}
	
	

}
