package com.crm.comcast.genericlibrary;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void impWaitForPage(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	public void expWaitForElementVisibility(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void customWait(WebElement element) throws InterruptedException {
		int count=0;
		while(count<20) {
			try {
				element.click();
				break;
			}
			catch (Exception e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	public void switchToWindow(WebDriver driver,String partialTitle) {
		Set<String> allwindow = driver.getWindowHandles();
		Iterator<String> switchwdw = allwindow.iterator();
		while(switchwdw.hasNext()) {
			String currentwindow = switchwdw.next();
			String title = driver.switchTo().window(currentwindow).getTitle();
			if(title.contains(partialTitle)) {
				break;
			}
		}
	}
	
	public void mouseHover(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element);
	}

}
