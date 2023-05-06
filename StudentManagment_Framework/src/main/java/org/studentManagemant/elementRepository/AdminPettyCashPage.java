package org.studentManagemant.elementRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyys.genericUtility.DriverClass;

public class AdminPettyCashPage {

	public AdminPettyCashPage() {
		PageFactory.initElements(DriverClass.getInstance().getDriver(), this);
	}
	
	@FindBy(xpath = "//td[text()='Pending']/following-sibling::td/a[text()='Approve']")
	private WebElement approve;
	
	
	@FindBy(xpath = "//a[@id='btnYesApprove']")
	private WebElement yesbtn;
	
	@FindBy(xpath = "//a[.='Next']")
	private WebElement nextbtn;
	
	@FindBy(xpath = "//div[@id='example1_info']")
	private WebElement pagecount;
	
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	private WebElement searchbtn;
    
	
	
	
	/**
	 * This method is used to get approval
	 * @return
	 */
	public void getAdminApprove() 
	{
		String count = pagecount.getText().split(" ")[5];
		
         searchbtn.sendKeys(count);
         approve.click();
        


	}
	
	/**
	 * This button is used to click yes
	 */
	public void clickOnYesBtn() {
		 yesbtn.click();
	}
	
	
	
}
