package com.crm.comcast.leadTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericlibrary.BaseClass;
import com.crm.comcast.pomrepository.CreateNewLead;
import com.crm.comcast.pomrepository.Home;
import com.crm.comcast.pomrepository.LeadInformation;
import com.crm.comcast.pomrepository.Leads;

public class CreateNewLeadGivingAnnualRevenueTest extends BaseClass {

	@Test
	public void createNewLeadGivingAnnualRevenueTest() throws Throwable {
		String lastName = elib.readDataFromExcel("lead", 1, 2);
		String company = elib.readDataFromExcel("lead", 1, 3);
		// String annualRevenue = elib.readDataFromExcel("lead",1,4);
		String annualRevenue = "123";

		Home hp = new Home(driver);
		wlib.impWaitForPage(driver);
		hp.getLeadLnk().click();

		Leads ld = new Leads(driver);
		ld.getCreateNwLeadImg().click();

		CreateNewLead cnl = new CreateNewLead(driver);
		cnl.createLeadAnnualRevenue(lastName, company, annualRevenue);

		LeadInformation li = new LeadInformation(driver);
		boolean leadNo = li.getLeadNoSuchMsgSuchMsg().isDisplayed();

		Assert.assertTrue(leadNo);

	}

}
