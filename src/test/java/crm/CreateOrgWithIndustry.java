package crm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.comcast.genericlibrary.ExcelUtility;
import com.crm.comcast.genericlibrary.FileUtility;
import com.crm.comcast.genericlibrary.JavaUtility;
import com.crm.comcast.genericlibrary.WebDriverUtility;
import com.crm.comcast.pomrepository.CreateNewOrganization;
import com.crm.comcast.pomrepository.Home;
import com.crm.comcast.pomrepository.Login;
import com.crm.comcast.pomrepository.Organization;
import com.crm.comcast.pomrepository.OrganizationInformation;

public class CreateOrgWithIndustry {

	public static void main(String[] args) throws Throwable {
		//create objects
		JavaUtility jlib=new JavaUtility();	
	    WebDriverUtility wlib=new WebDriverUtility();
	    FileUtility flib=new FileUtility();
	    ExcelUtility elib=new ExcelUtility();
	    WebDriver driver=null;
	 
	    // read data from property
	    String USERNAME = flib.readDataFromProperty("username");
	    String PASSWORD = flib.readDataFromProperty("password");
	    String URL = flib.readDataFromProperty("url");
	    String BROWSER = flib.readDataFromProperty("browser");
	    
	    //read data from excel
	    String orgName = elib.readDataFromExcel("org", 1, 2)+"_"+jlib.getRandomNum();
	    String industries = elib.readDataFromExcel("org", 4, 3);
	    
	    // open browser
	    if(BROWSER.equals("chrome"))
	    {
	    	driver=new ChromeDriver();
	    }
	    else if ((BROWSER.equals("firefox")))
	    		{
	    	driver=new FirefoxDriver();
	    	 }
	   // login to app
	   driver.get(URL);
	   Login lp=new Login(driver);
	   lp.LoginToApp(USERNAME, PASSWORD);
	   
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
		
	    
		String actIndustryInfo = orgin.getIndustryTxt().getText();
		if(actIndustryInfo.equals(industries))
		{
			System.out.println("org created with industries successfully==PASS");
		}
		else {
			System.out.println("org not created with industries  successfully==FAIL");
		}
		// logout
		hp.logout();
	    driver.quit();

	}

}
