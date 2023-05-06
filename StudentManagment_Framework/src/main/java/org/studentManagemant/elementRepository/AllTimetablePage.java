package org.studentManagemant.elementRepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyys.genericUtility.DriverClass;
import org.tyys.genericUtility.WebDriverUtility;

public class AllTimetablePage {
	
	public AllTimetablePage() {
		PageFactory.initElements(DriverClass.getInstance().getDriver(), this);
	}
	
	@FindBy(xpath = "//select[@id='grade']")
	private WebElement grade;
	
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitbtn;
	
	@FindBy(xpath="//th[text()='Thursday']/ancestor::thead/following-sibling::tbody//td")
	private List<WebElement> timetableDetail;
	/**
	 * This method is used to select the grade
	 * @param webdriver
	 * @param expectedGrade
	 */
	public void selectingGrade(WebDriverUtility webdriver,String expectedGrade) {
		webdriver.handleSelectDropDownByVisibleText(grade, expectedGrade);
		submitbtn.click();
	}
	/**
	 * This method is used to get all timetable details
	 * @return
	 */
	public List<String> getAllTimetableDetails() {
		List<String> list=new ArrayList<String>();
		for(WebElement thurdayDetail:timetableDetail) {
			list.add(thurdayDetail.getText());
		}
		return list;
	}
	
	
	

}
