package com.crm.comcast.leadTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericlibrary.BaseClass;
import com.crm.comcast.pomrepository.CreateNewLead;
import com.crm.comcast.pomrepository.Home;
import com.crm.comcast.pomrepository.Leads;

public class CreatNewLeadByGivingInvalidInputToAnnualRevenueTest extends BaseClass {

	@Test
	public void creatNewLeadByGivingInvalidInputToAnnualRevenue() throws Throwable {

		String lastName = elib.readDataFromExcel("lead", 1, 2);
		String company = elib.readDataFromExcel("lead", 1, 3);
		// String annualRevenue = elib.readDataFromExcel("lead",1,4);
		String annualRevenue = "ydff";
		String exptext = "Invalid Annual Revenue";

		Home hp = new Home(driver);
		wlib.impWaitForPage(driver);
		hp.getLeadLnk().click();

		Leads ld = new Leads(driver);
		ld.getCreateNwLeadImg().click();

		CreateNewLead cnl = new CreateNewLead(driver);
		cnl.createLeadAnnualRevenue(lastName, company, annualRevenue);
		// cnl.getSaveBtn().click();

		String text = driver.switchTo().alert().getText();
		System.out.println(text);
		driver.switchTo().alert().accept();
		Assert.assertEquals(text, exptext);

	}

}
