package org.tyys.genericUtility;

import org.openqa.selenium.WebDriver;
import org.studentManagemant.elementRepository.SMLoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public WebDriverUtility webdriver;
	public FileUtility fileutility;
	public JavaUtility javautility;
	public ExcelUtility excelutility;
	protected String url;
	public String username;
	public String password;
	protected String browser;
	protected long longTimeout;
	public SMLoginPage  loginpage;
	public WebDriver driver;
	public String adminusername;
	public String adminpassword;
	public long explicitlongtimeout;
	public int randomNumber;

//	@BeforeSuite
//	public void suiteSetUp() {
//
//
//	}

	@BeforeClass
	public void classSetUp() {
		//Creating object for the utility
		webdriver=new WebDriverUtility();
		fileutility=new FileUtility();
		javautility=new JavaUtility();
		excelutility=new ExcelUtility();
		
		DriverClass.getInstance().setWebdriver(webdriver);
		DriverClass.getInstance().setJavautility(javautility);
		DriverClass.getInstance().setFileutility(fileutility);
		DriverClass.getInstance().setExcelutility(excelutility);

		//intialize data from property file
		fileutility.intializePropertyFile(IConstantUtility.STUDENTMANAGEMENTPROPERTYFILEPATH);

		//get the control for the particular sheet in excel
		excelutility.initializeExcelFile(IConstantUtility.STUDENTMANAGEMENTEXCELFILEPATH);

		//fetching data from property file
		url = fileutility.getDataFromPropertyFile("url");
		username = fileutility.getDataFromPropertyFile("username");
		password = fileutility.getDataFromPropertyFile("password");
		browser = fileutility.getDataFromPropertyFile("browser");
		String timeout = fileutility.getDataFromPropertyFile("timeout");
		adminusername = fileutility.getDataFromPropertyFile("adminusername");
		adminpassword = fileutility.getDataFromPropertyFile("adminpassword");
		String explicittimeout = fileutility.getDataFromPropertyFile("explicittimeout");

		//converting string to long
		longTimeout = javautility.convertStringToLong(timeout);
		explicitlongtimeout = javautility.convertStringToLong(explicittimeout);
		//launching the browser based on browser key
		driver = webdriver.setupDriver(browser);

		DriverClass.getInstance().setDriver(driver);
		//creating object for common pom class
	  loginpage=new SMLoginPage();

		//pre-setting for the browser
		webdriver.maximizeBrowser();
		webdriver.implicitWait(longTimeout);

		//navigating to the application
		webdriver.openApplication(url);
		//Generate the random number
		randomNumber = javautility.getRandomNumber();
	}


	@AfterClass
	public void classTearDown() {

		webdriver.closeBrowser();
	}

}
