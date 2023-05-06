package org.studentManagemant.elementRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyys.genericUtility.DriverClass;
import org.tyys.genericUtility.WebDriverUtility;

public class My_PettyCashPage {

	public My_PettyCashPage() {
		PageFactory.initElements(DriverClass.getInstance().getDriver(), this);
	}
	@FindBy(xpath = "//a[text()='Add ']")
	private WebElement addbtn;

	@FindBy(xpath = "//input[@id='textDesc_1']")
	private WebElement description;

	@FindBy(xpath = "//input[@id='textAmount_1']")
	private WebElement amount;

	@FindBy(xpath = "//input[@id='btnSubmit']")
	private WebElement submitbtn;

	@FindBy(xpath ="//strong[text()='Success!']")
	private WebElement information;

	/**
	 * this method is used to add petty cash
	 */
	public void addPettyCash() {
		addbtn.click();
	}
	/**
	 * This method is used to add the amount in the petty cash
	 * @param Description
	 * @param Amount
	 */
	public void addPettyCashAmount(String Description,String Amount) {
		description.sendKeys(Description);
		amount.sendKeys(Amount);
		submitbtn.click();

	}
	/**
	 * This method is used to expicitly waiting for until poppup closing
	 * @param webdriver
	 */
	public void invisibleInformationMsg(WebDriverUtility webdriver,long longtimeout) {
		webdriver.initializeExplicitWait(longtimeout);
		webdriver.explicitWaitByInvisbilityOf(information);

	}

}
