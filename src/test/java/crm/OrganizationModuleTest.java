package crm;

import org.testng.annotations.Test;

import com.crm.comcast.genericlibrary.BaseClass;
import com.crm.comcast.pomrepository.CreateNewOrganization;
import com.crm.comcast.pomrepository.Home;
import com.crm.comcast.pomrepository.Organization;
import com.crm.comcast.pomrepository.OrganizationInformation;

public class OrganizationModuleTest extends BaseClass {
		/*@Test(groups ="smokeTest")
		public void CreateOrgTest() throws Throwable {
	    String orgName = elib.readDataFromExcel("org", 1, 2)+"_"+jlib.getRandomNum();
			
	    //navigate to organization
		Home hp=new Home(driver);
		hp.getOrgLnk().click();
		
		// create organization
		Organization org=new Organization(driver);
		org.getCreateNwOrgImg().click();
		
		CreateNewOrganization cnop=new CreateNewOrganization(driver);
		cnop.createOrg(orgName);
		
		
		OrganizationInformation orgin=new OrganizationInformation(driver);
		wlib.expWaitForElementVisibility(driver,orgin.getOrgHeaderTxt());
		String actorgMsg = orgin.getOrgHeaderTxt().getText();
		
		if(actorgMsg.contains(orgName))
		 {
			 System.out.println("organization created successfully==PASS");
		 }
		 else
		 {
			 System.out.println("organization not created successfully==FAIL");
		 }
			   
			   
		}*/
	    //2nd testcase
		
		@Test(groups ="regressionTest")
		public void CreateOrgWithIndustry() throws Throwable{
		
		String orgName = elib.readDataFromExcel("org", 1, 2)+"_"+jlib.getRandomNum();
		String industries = elib.readDataFromExcel("org", 4, 3);
		                  
		//navigate to organization
		Home hp=new Home(driver);
		hp.getOrgLnk().click();
		   
		   // create organization
		Organization org=new Organization(driver);
		wlib.impWaitForPage(driver);
		org.getCreateNwOrgImg().click();
			
			//creating organition name with industry
		CreateNewOrganization ctorg=new CreateNewOrganization(driver);
		ctorg.createOrg(orgName, industries);
			
			// verify the org info
		OrganizationInformation orgin=new OrganizationInformation(driver);
		String actorgMsg = orgin.getOrgHeaderTxt().getText();
			
		if(actorgMsg.contains(orgName))
		 {
		  System.out.println("organization created successfully==PASS");
		 }
		else
		 {
		System.out.println("organization not created successfully==FAIL");
		 }
			
		
		      			}
	}


