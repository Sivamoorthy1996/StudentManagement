package org.studentManagemant.elementRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyys.genericUtility.DriverClass;
import org.tyys.genericUtility.WebDriverUtility;

public class AdminTeacherPage {
	public AdminTeacherPage () {
		PageFactory.initElements(DriverClass.getInstance().getDriver(), this);
	}
	
	@FindBy(xpath = "//input[@id='index_number']")
	private WebElement indexnumber;
	
	@FindBy(xpath="//input[@id='full_name']")
	private WebElement fullname;
	
	@FindBy(xpath = "//input[@id='i_name']")
	private WebElement namewithInitial;
	
	@FindBy(xpath = "//input[@id='address']")
	private WebElement address;
	
	@FindBy(xpath = "//select[@id='gender']")
	private WebElement gender;
	
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phonenumber;
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailID;
	
	@FindBy(xpath = "//input[@id='fileToUpload']")
	private WebElement chooseBtn;
	
	@FindBy(xpath = "//button[@id='btnSubmit']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//div[@id='insert_Success']//h4")
	private WebElement InsertsuccessInfo;
	
	/**
	 * This method is used to create teacher
	 * @param indexNumber
	 * @param fullName
	 * @param nameWithInitials
	 * @param Address
	 * @param webDriverUtility
	 * @param visibleText
	 * @param phoneNumber
	 * @param email
	 * @param filePath
	 */
	public void addNewTeacher(String indexNumber,String fullName,String nameWithInitials,String Address,WebDriverUtility webDriverUtility,String visibleText,String phoneNumber,String email,String filePath)
	{
		indexnumber.sendKeys(indexNumber);
		fullname.sendKeys(fullName);
		namewithInitial.sendKeys(nameWithInitials);
		address.sendKeys(Address);
		webDriverUtility.handleSelectDropDownByVisibleText(gender,visibleText);
		phonenumber.sendKeys(phoneNumber);
		emailID.sendKeys(email);
		chooseBtn.sendKeys(filePath);
		submitBtn.click();
		
	}
	/**
	 * This method is used return webelement
	 * @param webdriver
	 */
	public  WebElement informationMsg() {
		
		return InsertsuccessInfo;
	}
	
	
	
	
	

}
