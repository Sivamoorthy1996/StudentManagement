package org.studentmanagement.adminaddteacher;

import java.util.List;

import org.studentManagemant.elementRepository.AdminTeacherPage;
import org.studentManagemant.elementRepository.AllTeacherPage;
import org.studentManagemant.elementRepository.SMAdminCommonPage;
import org.studentManagemant.elementRepository.subjectRoutingPage;
import org.testng.annotations.Test;
import org.tyys.genericUtility.BaseClass;
import org.tyys.genericUtility.IConstantUtility;

public class DeleteTeacherAdminTest extends BaseClass {

	
	@Test
	public void deleteTeacherAdminTest(){
		
		//fetching the data from property file
		String EmailID = fileutility.getDataFromPropertyFile("emailid");
		String domain = fileutility.getDataFromPropertyFile("domain");


		//fetch the data from excel file
		String indexnumber = excelutility.getDataFromExcelFile("teacher", 2, 1);
		String fullName = excelutility.getDataFromExcelFile("teacher", 2, 2);
		String nameWithInitial= excelutility.getDataFromExcelFile("teacher", 2, 3)+randomNumber;
		String Address= excelutility.getDataFromExcelFile("teacher", 2, 4);
		String Gender= excelutility.getDataFromExcelFile("teacher", 2, 5);
		String phoneNumber= excelutility.getDataFromExcelFile("teacher", 2, 6);
		String switchelement= excelutility.getDataFromExcelFile("teacher", 2, 9);
		String partialText= excelutility.getDataFromExcelFile("teacher", 2, 7);

		//Creating object for the pom repo classes
		
		SMAdminCommonPage commonpage=new SMAdminCommonPage();
		AdminTeacherPage teacherpage=new AdminTeacherPage();
		AllTeacherPage allteacherpage=new AllTeacherPage();
		subjectRoutingPage subjectRoutingPage=new subjectRoutingPage();

		//login to the application
		loginpage.loginAction(adminusername, adminpassword);
		commonpage.clickOnTeacherTab();
		commonpage.clickOnAddTeacherTab();
		teacherpage.addNewTeacher(indexnumber, fullName, nameWithInitial, Address, webdriver, Gender, phoneNumber, EmailID+randomNumber+domain,IConstantUtility.TEACHERPROFILEPHOTO);;
		webdriver.initializeExplicitWait(explicitlongtimeout);
		webdriver.explicitWaitByInvisbilityOf(teacherpage.informationMsg());
		commonpage.clickOnTeacherTab();
		commonpage.clickOnAllTeacher();
		allteacherpage.deleteParticularTeacher(nameWithInitial, nameWithInitial);
		webdriver.SwitchWindow(partialText, "title");
		webdriver.explicitWaitByVisbilityOf(allteacherpage.yesinformationMsg());    	
		allteacherpage.clickOnYesbtn();
		webdriver.explicitWaitByInvisbilityOf(allteacherpage.informationMsg());
		commonpage.clickOnsubjectRouting();
		subjectRoutingPage.clickOnAddbtn();
		webdriver.SwitchWindow(switchelement,"title");
		List<String> listOfTeacher = subjectRoutingPage.verifyTeacherdetails();
		int count=0;
		for(String teacher:listOfTeacher) 
		{
			if(nameWithInitial.equals(teacher))
			{
				count++;

			}

		}

		if(count==0) {
			javautility.printStatement("Add teacher is present in the list and the test case is pass");
		}
		else
			javautility.printStatement("Add teacher is not present in the list and the test case is fail");


		subjectRoutingPage.cancelBtn();
		commonpage.logoutAction();
		

	}

}
