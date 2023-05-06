package org.tyys.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * This class contains resuable method of property file
 * @author Sivasubramaniam.M
 *
 */
public final class FileUtility {
	private Properties properties;
	/**
	 * This method is used to intilize the property file
	 * @param FilePath
	 */
	public void  intializePropertyFile(String FilePath) {
		FileInputStream fis=null;
		try {
		fis=new FileInputStream(FilePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	    properties=new Properties();
		try {
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * This method is used to get data from the property file
	 * @param Data
	 * @return
	 */
	public String getDataFromPropertyFile(String Data) {
		return properties.getProperty(Data);
		
	}
	

}
