package org.studentManagemant.elementRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyys.genericUtility.DriverClass;
import org.tyys.genericUtility.WebDriverUtility;

public class MyTimetablePage {
	public MyTimetablePage() {
		PageFactory.initElements(DriverClass.getInstance().getDriver(), this);
	}
	@FindBy(xpath = "//a[text()='Add ']")
	private WebElement addbtn;
	
	@FindBy(xpath = "//select[@id='day']")
	private WebElement dayDropDown;
	
	@FindBy(xpath = "//select[@id='grade']")
	private WebElement gradeDropDown;
	
	@FindBy(xpath = "//select[@id='subject']")
	private WebElement SubjectDropDown;
	
	@FindBy(xpath = "//select[@id='classroom']")
	private WebElement classroomDropDown;
	
	@FindBy(xpath = "//input[@id='start_time']")
	private WebElement startTimeTextField;
	
	@FindBy(xpath = "//input[@id='end_time']")
	private WebElement endTimeTextField;
	
	@FindBy(xpath = "//button[@id='btnSubmit']")
	private WebElement submitbtn;
	/**
	 * This method is used to add timetable
	 */
	public void addSubjectRouting() {
		addbtn.click();
	}
	
	/**
	 * This method is used to select the day
	 * @param webdriver
	 * @param expectedDay
	 */
	public void dayDropDownBox(WebDriverUtility webdriver,String expectedDay) 
	{
		webdriver.handleSelectDropDownByVisibleText( dayDropDown,expectedDay);
	}
	/**
	 * This method is used to select the grade
	 * @param webdriver
	 * @param expectedGrade
	 */
	public void gradeDropDownBox(WebDriverUtility webdriver,String expectedGrade) {
		webdriver.handleSelectDropDownByVisibleText( gradeDropDown,expectedGrade);
	}
	/**
	 * This method is used to select the subject
	 * @param webdriver
	 * @param expectedsubject
	 */
	public void subjectDropDownBox(WebDriverUtility webdriver,String expectedsubject) {
		webdriver.handleSelectDropDownByVisibleText( SubjectDropDown,expectedsubject);
	}
	
	/**
	 * This method is used to select the classroom
	 * @param webdriver
	 * @param expectedclassroom
	 */
	public void classroomDropDownBox(WebDriverUtility webdriver,String expectedclassroom) {
		webdriver.handleSelectDropDownByVisibleText( classroomDropDown,expectedclassroom);
	}
	/**
	 * This method is used to set the start and end time
	 * @param StartingTime
	 * @param EndingTime
	 */
    public void startAndEndTimeText(String StartingTime,String EndingTime) {
    	startTimeTextField.sendKeys(StartingTime);
    	endTimeTextField.sendKeys(EndingTime);
    	submitbtn.click();
    }
}
