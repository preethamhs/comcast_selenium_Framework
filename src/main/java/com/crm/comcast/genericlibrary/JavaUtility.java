package com.crm.comcast.genericlibrary;

import java.util.Random;

public class JavaUtility {

	public int getRandomNum(){
		Random ran=new Random();
		int ranNum = ran.nextInt(10000);
		return ranNum;
	}
}
