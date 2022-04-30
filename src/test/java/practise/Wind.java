package practise;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Wind {
	
	@Test void windows() throws AWTException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		WebElement title = driver.findElement(By.linkText("actiTIME Inc."));
		Actions a=new Actions(driver);
		a.contextClick(title).perform();
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_W);
		
	}

}
