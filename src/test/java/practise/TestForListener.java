package practise;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.genericlibrary.BaseClass;
import com.crm.comcast.pomrepository.Home;

@Listeners(com.crm.comcast.genericlibrary.ListenerImp.class)
public class TestForListener extends BaseClass {
	
	@Test
	public void contactTest() {
		
		Home hp=new Home(driver);
		hp.getContactLnk().click();
		
		Assert.assertEquals("A","B");
	}

}
