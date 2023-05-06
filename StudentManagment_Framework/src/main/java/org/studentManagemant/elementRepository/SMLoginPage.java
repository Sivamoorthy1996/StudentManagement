package org.studentManagemant.elementRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyys.genericUtility.DriverClass;

public class SMLoginPage {
	@FindBy(xpath = "//input[@id='email']")
	private WebElement usernameTextField;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordTextField;
	
	@FindBy(xpath = "//button[@id='btnSubmit']")
	private WebElement submitbtn;
	
	
	public SMLoginPage() {
		PageFactory.initElements(DriverClass.getInstance().getDriver(), this);
	}
	/**
	 * This method is used to login with the application
	 * @param teacherUserName
	 * @param teacherPassword
	 */
	public void loginAction(String teacherUserName,String teacherPassword) {
		usernameTextField.sendKeys(teacherUserName);
		passwordTextField.sendKeys(teacherPassword);
		submitbtn.click();
	}
	/**
	 * This method is used to login with the application
	 * @param adminUserName
	 * @param adminPassword
	 */
	public void adminLoginAction(String adminUserName,String adminPassword) {
		usernameTextField.sendKeys(adminUserName);
		passwordTextField.sendKeys(adminPassword);
		submitbtn.click();
	}
}
