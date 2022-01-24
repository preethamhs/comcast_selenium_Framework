package practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromProp {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\Preetham\\Desktop\\commonData.property");
		Properties p=new Properties();
		p.load(fis); 

	}

}
