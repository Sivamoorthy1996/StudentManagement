package org.studentmanagement.pettycase;

import org.studentManagemant.elementRepository.AdminPettyCashPage;
import org.studentManagemant.elementRepository.My_PettyCashPage;
import org.studentManagemant.elementRepository.SMAdminCommonPage;
import org.studentManagemant.elementRepository.SMCommonPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.tyys.genericUtility.BaseClass;
@Listeners(org.tyys.genericUtility.ListenerImplementation.class)
public class CreatePettyCashTest extends BaseClass {

	@Test
	public void createPettyCashTest() {



		//fetching the data from property file
		String description = fileutility.getDataFromPropertyFile("description");
		String amount = fileutility.getDataFromPropertyFile("amount");

		String partialtext = fileutility.getDataFromPropertyFile("partialtext");



		//Creating object for the pom repo classes
	
		SMCommonPage commonpage=new SMCommonPage();
		My_PettyCashPage pettycashpage=new My_PettyCashPage();
		AdminPettyCashPage adminpettycashpage=new AdminPettyCashPage();
		SMAdminCommonPage admincommonpage=new SMAdminCommonPage();

		//login to the application
		loginpage.loginAction(username, password);
		commonpage.clickOnMyPettyCash();
		pettycashpage.addPettyCash();
		pettycashpage.addPettyCashAmount(description, amount);
		pettycashpage.invisibleInformationMsg(webdriver,explicitlongtimeout);
		commonpage.logoutAction();
		loginpage.loginAction(adminusername, adminpassword);
		admincommonpage.clickOnpettycash();
		adminpettycashpage.getAdminApprove();
		webdriver.SwitchWindow(partialtext, "title");
		Assert.fail();
		adminpettycashpage.clickOnYesBtn();
		


	}

}
