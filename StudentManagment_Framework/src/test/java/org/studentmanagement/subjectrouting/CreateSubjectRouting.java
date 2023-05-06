package org.studentmanagement.subjectrouting;

import org.studentManagemant.elementRepository.SMAdminCommonPage;
import org.studentManagemant.elementRepository.subjectRoutingPage;
import org.testng.annotations.Test;
import org.tyys.genericUtility.BaseClass;

public class CreateSubjectRouting extends BaseClass {
	
	
@Test
	public void createSubjectRouting()  {
		
		//fetch the data from excel file
				String grade = excelutility.getDataFromExcelFile("subjectrouting", 2, 1);
				String subject = excelutility.getDataFromExcelFile("subjectrouting", 2, 2);
				String teacher = excelutility.getDataFromExcelFile("subjectrouting", 2, 3);
				String fees = excelutility.getDataFromExcelFile("subjectrouting", 2, 4);
				String partialtext = excelutility.getDataFromExcelFile("subjectrouting", 2, 5);
				
				//Creating object for the pom repo classes
			   SMAdminCommonPage commonpage = new SMAdminCommonPage();
			   subjectRoutingPage subjectroutingpage=new subjectRoutingPage();
				
				//login to the application
			    loginpage.loginAction(adminusername, adminpassword);
			    commonpage.clickOnsubjectRouting();
			    subjectroutingpage.clickOnAddbtn();
			    webdriver.SwitchWindow(partialtext, fees);
			    subjectroutingpage.gradeDropDownBox(webdriver, grade);
			    subjectroutingpage.subjectDropDownBox(webdriver, subject);
			    subjectroutingpage.TeacherDropDownBox(webdriver, teacher, fees);
			   
				

		
		
		

	}

}
