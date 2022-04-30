package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.ui.Select;

public class SampleTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@value='Login']")).submit();
		driver.findElement(By.linkText("Organizations")).click();
		String txt = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[3]/td[contains(.,'vtiger')]")).get(0).getText();
        System.out.println(txt);
        System.out.println(driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[3]/td[last()-1]")).getText());
        Actions a=new Actions(driver);
        Select s=new Select(driver.findElement(By.linkText("Organizations")));
        
	}

}
