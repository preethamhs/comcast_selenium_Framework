package com.crm.comcast.contactTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.comcast.genericlibrary.BaseClass;
import com.crm.comcast.pomrepository.Contact;
import com.crm.comcast.pomrepository.ContactInformation;
import com.crm.comcast.pomrepository.CreateNewContact;
import com.crm.comcast.pomrepository.CreateNewOrganization;
import com.crm.comcast.pomrepository.Home;
import com.crm.comcast.pomrepository.Organization;
import com.crm.comcast.pomrepository.OrganizationInformation;

@Listeners(com.crm.comcast.genericlibrary.ListenerImp.class)
public class ContactModuleTest extends BaseClass {
	@Test(groups ="someTest")
	public void CreateContactTest() throws Throwable {
		
		String lastName = elib.readDataFromExcel("contact", 1, 2)+"_"+jlib.getRandomNum();
		
		   Home hp=new Home(driver);
		   wlib.impWaitForPage(driver);
		   hp.getContactLnk().click();
		   
		   // navigate create new contact page
		   Contact cp=new Contact(driver);
		   cp.getCreateNwContactImg().click();
		   
		   
		   //create contact
		   CreateNewContact cnp=new CreateNewContact(driver);
		   cnp.createContact(lastName);
		   
		   //verify the contact details
		   ContactInformation ci=new ContactInformation(driver);
		   String actLstName = ci.getOrgHeaderSuchMsg().getText();
		   Assert.assertTrue(actLstName.contains(lastName));
	}
	
	// 2nd testcase
		   @Test(groups ="regressionTest")
			public void CreateContactWithOrgTest() throws Throwable {
			   String orgName = elib.readDataFromExcel("org", 1, 2)+"_"+jlib.getRandomNum();
			   String lastName = elib.readDataFromExcel("contact", 1, 2)+"_"+jlib.getRandomNum();
			 //navigate to organization
			   Home hp=new Home(driver);
			   hp.getOrgLnk().click();
			   
			   // navigate to org page
				Organization org=new Organization(driver);
				wlib.impWaitForPage(driver);
				org.getCreateNwOrgImg().click();
				
				// create organization
				CreateNewOrganization cnop=new CreateNewOrganization(driver);
				cnop.createOrg(orgName);
				
				//wait for header element
				OrganizationInformation oi=new OrganizationInformation(driver);
				wlib.expWaitForElementVisibility(driver,oi.getIndustryTxt());
				
				// navigate to contact page
				hp.getContactLnk().click();
				
				// navigate to create new contact
				Contact cp= new Contact(driver);
				cp.getCreateNwContactImg().click();
				
				//create a new contact with orgName page
				CreateNewContact cnp=new CreateNewContact(driver);
				cnp.createContact(lastName, orgName);
				
				
				//verify the details
				ContactInformation ci=new ContactInformation(driver);
				Thread.sleep(3000);
				String actName = ci.getOrgHeaderSuchMsg().getText();
				Assert.assertTrue(actName.contains(lastName));
				
				SoftAssert soft=new SoftAssert();
				String actOrgName = ci.getOrgNameInfo().getText();
				soft.assertEquals(actOrgName.trim(), orgName);
				soft.assertAll();
}}
