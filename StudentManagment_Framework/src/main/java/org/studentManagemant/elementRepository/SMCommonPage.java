package org.studentManagemant.elementRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyys.genericUtility.DriverClass;

public class SMCommonPage {
	public SMCommonPage() {
		PageFactory.initElements(DriverClass.getInstance().getDriver(), this);
	}
	@FindBy(xpath="//span[text()='Timetable']")
	private WebElement timetableTab;
	
	@FindBy(xpath="//a[text()=' My Timetable']")
	private WebElement myTimetableTab;
	
	@FindBy(xpath="//a[text()='All Timetable']")
	private WebElement allTimetableTab;
	
	@FindBy(xpath="//span[@class='hidden-xs']")
	private WebElement teacherTab;
	
	@FindBy(xpath="//a[text()='Sign out']")
	private WebElement signoutTab;
	
	@FindBy(xpath="//span[text()='My Petty Cash']")
	private WebElement MyPettyCashTab;
	
    /**
     * This method is used to click the timetable tab
     */
	public void clickOnTimetable() {
		timetableTab.click();
	}
	/**
	 * This method is used to click on the my timetable
	 */
	public void clickOnMyTimetable() {
		myTimetableTab.click();
	}
	
	
	/**
	 * This method is used to click allTimetabletab
	 */
	public void clickOnAllTimetable() {
		allTimetableTab.click();
	}
	/**
	 * This method is used to click my petty cash
	 */
	public void clickOnMyPettyCash() {
	MyPettyCashTab.click();
	}
	/**
	 * This method is used to signout
	 */
	public void logoutAction() {
		teacherTab.click();
		signoutTab.click();
	}
	
	
	
	

}
