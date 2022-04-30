package practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FlipkartForPhone {
	
	@Test
	public void flipkart() throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[.='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("phone");
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		
		List<WebElement> allphone = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		
		for (int i=0; i<allphone.size();i++) {

			String phonetxt = allphone.get(i).getText();
			FileInputStream fis=new FileInputStream("./data/testData.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			wb.getSheet("flipkart").getRow(i).createCell(1).setCellValue(phonetxt);
			FileOutputStream fos=new FileOutputStream("./data/testData.xlsx");
			wb.write(fos);
			wb.close();
		}
		
		driver.close();
		
	}

}
