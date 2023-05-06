package org.studentManagemant.elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyys.genericUtility.DriverClass;

public class AllTeacherPage {
	
	public  AllTeacherPage () {
	
		PageFactory.initElements(DriverClass.getInstance().getDriver(), this);
	}
	
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	private WebElement searchtab;
	
	@FindBy(xpath = "//a[@id='btnYes']")
	private WebElement yesbtn;
	
	
	@FindBy(xpath = "//div[@id='delete_Success']//h4")
	private WebElement deleteInfo;
	
	@FindBy(xpath = "//div[@id='deleteConfirm']//a")
	private WebElement yesinformationInfo;
	
	
	
	private String particularDeleteBox="//a[contains(text(),'%s')]/parent::td/following-sibling::td/a[@class='confirm-delete btn btn-danger btn-xs']";
	
	public WebElement convertdynamicxpathtoWebElement(String elementPartialXpath,String replaceData)
	{
		String xpath=String.format(elementPartialXpath, replaceData);
		return DriverClass.getInstance().getDriver().findElement(By.xpath(xpath));
	}
	
	public void deleteParticularTeacher(String replaceData,String requiredDataToDelete)
	{   searchtab.sendKeys(requiredDataToDelete);
		convertdynamicxpathtoWebElement(particularDeleteBox,replaceData).click();
	}
	public void clickOnYesbtn() {
		yesbtn.click();
	}
	/**
	 * This method is used return webelement
	 * @param webdriver
	 */
	public  WebElement informationMsg() {
		
		return deleteInfo;
	}
     public  WebElement yesinformationMsg() {
		
		return yesinformationInfo;
	}
	
	
}
