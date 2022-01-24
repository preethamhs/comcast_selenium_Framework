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
import com.crm.comcast.pomrepository.Home;
import com.crm.comcast.pomrepository.Login;

public class CreateContactTest {
	@Test
	public void CreateContactTest() throws Throwable {
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
	   
	   //navigate to contact page
	   Home hp=new Home(driver);
	   hp.getContactLnk().click();
	   
	   // navigate create new contact page
	   Contact cp=new Contact(driver);
	   wlib.impWaitForPage(driver);
	   cp.getCreateNwContactImg().click();
	   
	   
	   //create contact
	   CreateNewContact cnp=new CreateNewContact(driver);
	   cnp.createContact(lastName);
	   
	   //verify the contact details
	   ContactInformation ci=new ContactInformation(driver);
	   String actLstName = ci.getOrgHeaderSuchMsg().getText();
	   
	   if(actLstName.contains(lastName)) {
		   System.out.println(lastName+" contact last name is verified & PASS");
	   }
	   else {
		   System.out.println(lastName+" contact last name is not verified & FAIL");
	   }
	   //logout
	   hp.logout();
	   driver.quit();

	}

}
	
