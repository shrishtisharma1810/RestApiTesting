package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
//declaring prop obj
public Properties prop;
public int RESPONSE_STATUS_CODE_200 =200;
public int RESPONSE_STATUS_CODE_201 =201;
public int RESPONSE_STATUS_CODE_400 =400;
public int RESPONSE_STATUS_CODE_204 =204;
public int RESPONSE_STATUS_CODE_500 =500;

public TestBase() throws IOException
{
		
	try {
		//create prop obj
		prop=new Properties();
		
		//create FIS obj
		FileInputStream fips= new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.properties");
		//load properties file
		prop.load(fips);
	}catch(FileNotFoundException e) {
		e.printStackTrace();
	}catch(IOException e)
	{
		e.printStackTrace();
	}
}

}
