package practise;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericlibrary.BaseClass;
import com.crm.comcast.pomrepository.Home;

public class RetryFeatures extends BaseClass {
	
	@Test(retryAnalyzer = com.crm.comcast.genericlibrary.ReTryImp.class)
	public void contactTest() {
		Home hp=new Home(driver);
		hp.getContactLnk().click();
		
		Assert.assertEquals("a","b");
	}

}
