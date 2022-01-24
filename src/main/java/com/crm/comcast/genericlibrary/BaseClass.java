package com.crm.comcast.genericlibrary;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.comcast.pomrepository.Home;
import com.crm.comcast.pomrepository.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	public JavaUtility jlib=new JavaUtility();	
	public WebDriverUtility wlib=new WebDriverUtility();
	public FileUtility flib=new FileUtility();
	public ExcelUtility elib=new ExcelUtility();
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void connectDatabase() {
		System.out.println("=======database connection done========");
	}
	
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void disconnectDatabase() {
		System.out.println("========database connection disconected======");
	}
	
	//@Parameters("browser")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void launchBrowser(/*String BROWSER*/) throws Throwable {
		System.out.println("=========launch browser=========");
		 // read data from property
	    String URL = flib.readDataFromProperty("url");
	    String BROWSER = flib.readDataFromProperty("browser");
	    
	    //read data from excel
	    String lastName = elib.readDataFromExcel("contact", 1, 2)+"_"+jlib.getRandomNum();
	    
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
	   sdriver=driver;
	}
	
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void configBM() throws Throwable {
		
		String USERNAME = flib.readDataFromProperty("username");
	    String PASSWORD = flib.readDataFromProperty("password");
	    Login lp=new Login(driver);
		   lp.LoginToApp(USERNAME, PASSWORD);
	}
	
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void configAM() {
		Home hp=new Home(driver);
		hp.logout();
	}
	
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void configAC() {
		System.out.println("=======close browser=======");
		driver.quit();
	}
}

