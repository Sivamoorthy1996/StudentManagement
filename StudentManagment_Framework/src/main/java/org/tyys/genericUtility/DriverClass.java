package org.tyys.genericUtility;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

public class DriverClass {
	
	private static DriverClass varclass;
	
	private DriverClass() {
		
	}
	
	public static DriverClass getInstance() {
		if(Objects.isNull(varclass)) {
			 varclass=new DriverClass();
		}
		return varclass;
	}
	
	private WebDriver driver;
	private WebDriverUtility webdriver;
	private FileUtility fileutility;
	private ExcelUtility excelutility;
	private JavaUtility javautility;
	

	public WebDriverUtility getWebdriver() {
		return webdriver;
	}

	public void setWebdriver(WebDriverUtility webdriver) {
		this.webdriver = webdriver;
	}

	public FileUtility getFileutility() {
		return fileutility;
	}

	public void setFileutility(FileUtility fileutility) {
		this.fileutility = fileutility;
	}

	public ExcelUtility getExcelutility() {
		return excelutility;
	}

	public void setExcelutility(ExcelUtility excelutility) {
		this.excelutility = excelutility;
	}

	public JavaUtility getJavautility() {
		return javautility;
	}

	public void setJavautility(JavaUtility javautility) {
		this.javautility = javautility;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

}
