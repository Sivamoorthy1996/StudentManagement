package org.studentManagemant.elementRepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyys.genericUtility.DriverClass;
import org.tyys.genericUtility.WebDriverUtility;

public class subjectRoutingPage {
	
	public subjectRoutingPage () {
		PageFactory.initElements(DriverClass.getInstance().getDriver(), this);
	}
	
	@FindBy(xpath = "//a[@class='btn btn-success btn-sm pull-right']")
	private WebElement addbtn;
	
	@FindBy(xpath = "//select[@id='grade']")
	private WebElement gradeDropBtn;
	
	@FindBy(xpath = "//select[@id='subject']")
	private WebElement subjectDropBtn;
	@FindBy(xpath = "//select[@id='teacher']")
	private WebElement teacherDropBtn;
	
	@FindBy(xpath = "//input[@id='fee']")
	private WebElement feeTextBtn;

	@FindBy(xpath = "//button[@id='btnSubmit']")
	private WebElement submitBtn;

	
	@FindBy(xpath = "//select[@id='teacher']/option")
	private List<WebElement> createdTeacherOption;
	
	@FindBy(xpath="//div[@class='panel-heading']//span")
	private WebElement cancelbtn;
	
	@FindBy(xpath = "//a[@aria-controls='example1']")
	private List<WebElement> pagecount;
	
	@FindBy(xpath = "//table[@id='example1']//tbody//td[3]")
	private List<WebElement> verifysubject;
	
	@FindBy(xpath = "//table[@id='example1']//tbody//td[5]")
	private List<WebElement> verifyfees;


	/**
	 * This method is used to click on the add btn
	 */
	public void clickOnAddbtn() {
		addbtn.click();
	}
	/**
	 * This method is used to verify the element of teacher
	 * @return
	 */
	public List<String> verifyTeacherdetails() {
		List<String> list=new ArrayList<String>();
		for(int i=0;i<createdTeacherOption.size();i++)
		{
			list.add(createdTeacherOption.get(i).getText());
		}
		return list;
	}
	/**
	 * This method is used to cancel
	 */
	public void cancelBtn() {
		cancelbtn.click();
	}
	/**
	 * This method is used to select the grade
	 * @param webdriver
	 * @param expectedGrade
	 */
	public void gradeDropDownBox(WebDriverUtility webdriver,String expectedGrade) {
		webdriver.handleSelectDropDownByVisibleText( gradeDropBtn,expectedGrade);
	}
	/**
	 * This method is used to select the subject
	 * @param webdriver
	 * @param expectedSubject
	 */
	public void subjectDropDownBox(WebDriverUtility webdriver,String expectedSubject) {
		webdriver.handleSelectDropDownByVisibleText( subjectDropBtn,expectedSubject);
	}
	
	/**
	 * This method is used to select the teacher
	 * @param webdriver
	 * @param expectedTeacher
	 * @param expectedFees
	 */
	public void TeacherDropDownBox(WebDriverUtility webdriver,String expectedTeacher,String expectedFees) {
		webdriver.handleSelectDropDownByVisibleText( teacherDropBtn,expectedTeacher);
		feeTextBtn.sendKeys(expectedFees);
		submitBtn.click();
	}
	
	public void verifySubjectAndFees() {
      //for
	}
	
	
	
	
	

}
