package practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Destination {
	@Test(dataProvider ="bookTicketTest")
	public void bookTikTest(String src,String dest) {
		System.out.println("book ticket from "+src+" to "+dest);
	}
	
	@DataProvider
	public Object[][] bookTicketTest(){
		Object[][] obj=new Object[3][2];
		
		obj[0][0]="bangalore";
		obj[0][1]="mumbai";
		
		obj[1][0]="goa";
		obj[1][1]="pune";
		
		obj[2][0]="mangalore";
		obj[2][1]="kerala";
		return obj;
	}

}
