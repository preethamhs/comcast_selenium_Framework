package crm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.comcast.genericlibrary.ExcelUtility;
import com.crm.comcast.genericlibrary.FileUtility;
import com.crm.comcast.genericlibrary.JavaUtility;
import com.crm.comcast.genericlibrary.WebDriverUtility;
import com.crm.comcast.pomrepository.Contact;
import com.crm.comcast.pomrepository.ContactInformation;
import com.crm.comcast.pomrepository.CreateNewContact;
import com.crm.comcast.pomrepository.CreateNewOrganization;
import com.crm.comcast.pomrepository.Home;
import com.crm.comcast.pomrepository.Login;
import com.crm.comcast.pomrepository.Organization;
import com.crm.comcast.pomrepository.OrganizationInformation;

public class CreateContactWithOrgTest {

	@Test
	public void CreateContactWithOrgTest() throws Throwable {
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
	  //read data from excel
	    String orgName = elib.readDataFromExcel("org", 1, 2)+"_"+jlib.getRandomNum();
	    System.out.println(orgName);
	    String lastName = elib.readDataFromExcel("contact", 1, 2)+"_"+jlib.getRandomNum();
	    
	    // open browser
	    if(BROWSER.equals("chrome"))
	    {
	    	driver=new FirefoxDriver();
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
		String actName = ci.getOrgHeaderSuchMsg().getText();
		if(actName.contains(lastName)) {
			   System.out.println(lastName+" contact last name is verified & PASS");
		   }
		   else {
			   System.out.println(lastName+" contact last name is not verified & FAIL");
		   }
		
		String actOrgName = ci.getOrgNameInfo().getText();
		if(actOrgName.trim().equals(orgName)) {
			System.out.println(orgName+" is verified in contact page and pass");
		}
		else {
			System.out.println(orgName+" is not verified in contact page and fail");
		}
		
		//logout
		hp.logout();
		driver.close();

}

	}

