package crm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.comcast.genericlibrary.BaseClass;
import com.crm.comcast.genericlibrary.ExcelUtility;
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
		
		@Test(dataProvider="orgDataprovider",groups = "regressionTest")
		public void CreateOrgWithIndustry(String orgName1,String industries) throws Throwable{
		
		//String orgName = elib.readDataFromExcel("org", 1, 2)+"_"+jlib.getRandomNum();
		//String industries = elib.readDataFromExcel("org", 4, 3);
		  String orgName = orgName1+"_"+jlib.getRandomNum();        
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
		@DataProvider
		 public Object[][] orgDataprovider() throws Throwable{
			 ExcelUtility elib=new ExcelUtility();
			 int rowcount = elib.readDataFromExcelRowCount("dataorg");
			 
			 Object[][] objArr=new Object[rowcount][2];
			 for(int i=0;i<rowcount;i++) {
				 objArr[i][0]=elib.readDataFromExcel("dataorg",i,0);
				 objArr[i][1]=elib.readDataFromExcel("dataorg",i,1);
			 }
			 return objArr;
		 }
	}


