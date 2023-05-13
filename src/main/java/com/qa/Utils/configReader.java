package com.qa.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configReader {
	private Properties prop;
	/*
	 * This Method is used for the load the properties forom config.properties file
	 *@return  it returningg properties prop object
	 *
	 */
	public Properties init_prop()  {
		prop= new Properties();
		try {
			FileInputStream ip=new FileInputStream("src/test/resources/Config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return prop;
	}

}
