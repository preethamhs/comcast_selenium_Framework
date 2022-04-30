package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.crm.comcast.genericlibrary.ListenerImp.class)
public class ExtentReport {
	
	@Test
	public void report() {
		WebDriver driver=new ChromeDriver();
		Reporter.log("launching browser",true);
		
		driver.get("http://localhost:8888");
		Reporter.log("open vtiger",true);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Reporter.log("wait for load",true);
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		Reporter.log("Entering username",true);
		
		driver.findElement(By.name("user_password")).sendKeys("admin");
		Reporter.log("Entering password",true);
		
		driver.findElement(By.xpath("//input[@value='Login']")).submit();
		Reporter.log("ennter submit button",true);
		
	}

}
