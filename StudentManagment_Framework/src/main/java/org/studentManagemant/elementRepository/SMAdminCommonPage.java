package org.studentManagemant.elementRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyys.genericUtility.DriverClass;

public class SMAdminCommonPage {
	public SMAdminCommonPage() {
		PageFactory.initElements(DriverClass.getInstance().getDriver(), this);
	}
	
	@FindBy(xpath = "//span[text()='Petty Cash']")
	private WebElement pettycash;
	
	@FindBy(xpath="//span[@class='hidden-xs']")
	private WebElement developerTab;
	
	@FindBy(xpath = "//a[text()='Sign out']")
	private WebElement signOutLink;
	
	@FindBy(xpath = "//span[text()='Teacher']")
	private WebElement teacherTab;
	
	@FindBy(xpath = "//a[text()=' Add Teacher']")
	private WebElement addTeacherTab;
	
	@FindBy(xpath = "//span[text()='Subject Routing']")
	private WebElement subjectroutingTab;
	
	@FindBy(xpath = "//a[@href='all_teacher.php']")
	private WebElement allTeacherTab;
	
	/**
	 * This method is used click on the petty cash
	 */
	public void clickOnpettycash() {
		pettycash.click();
	}
	/**
	 * This method is used to click on allteacher module
	 */
	public void clickOnAllTeacher() {
		allTeacherTab.click();
	}
	/**
	 * This method is used click on the subject routing
	 */
	public void clickOnsubjectRouting() {
		subjectroutingTab.click();
	}
	/**
	 * This method is used to click on teacher tab
	 */
	public void clickOnTeacherTab() {
		teacherTab.click();
	}
	/**
	 * This method is used to click on add teacher
	 */
	public void clickOnAddTeacherTab() {
		addTeacherTab.click();
	}
	/**
	 * This method is used to signout
	 */
	public void logoutAction() {
		developerTab.click();
		signOutLink.click();
	}
	

}
