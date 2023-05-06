package org.sudentmanagement.timetable;


import java.util.List;

import org.studentManagemant.elementRepository.AllTimetablePage;
import org.studentManagemant.elementRepository.MyTimetablePage;
import org.studentManagemant.elementRepository.SMCommonPage;
import org.testng.annotations.Test;
import org.tyys.genericUtility.BaseClass;

public class CreateTimetableTest extends BaseClass {

	@Test
	public void createTimetableTest(){

		//fetching the data from property file
		String startTime = fileutility.getDataFromPropertyFile("start");
		String endTime = fileutility.getDataFromPropertyFile("end");

		//fetch the data from excel file
		String day = excelutility.getDataFromExcelFile("timetable", 2, 1);
		String grade = excelutility.getDataFromExcelFile("timetable", 2, 2);
		String classroom = excelutility.getDataFromExcelFile("timetable", 2, 3);
		String partialtext = excelutility.getDataFromExcelFile("timetable", 2, 6);


		//Creating object for the pom repo classes
		SMCommonPage commonpage=new SMCommonPage();
		MyTimetablePage mytimetablepage = new MyTimetablePage();
		AllTimetablePage alltimetable=new AllTimetablePage();

		//login to the application
	    loginpage.loginAction(username, password);
		//creating timetable action
		commonpage.clickOnTimetable();
		commonpage.clickOnMyTimetable();
		mytimetablepage.addSubjectRouting();
		webdriver.SwitchWindow(partialtext, "title");
		mytimetablepage.dayDropDownBox(webdriver, day);
		mytimetablepage.gradeDropDownBox(webdriver, grade);
		mytimetablepage.classroomDropDownBox(webdriver, classroom);
		mytimetablepage.startAndEndTimeText(startTime,endTime );
		commonpage.clickOnTimetable();
		commonpage.clickOnAllTimetable();
		alltimetable.selectingGrade(webdriver, grade);
		List<String> alldata = alltimetable.getAllTimetableDetails();
		int count = 0;
		for(String data:alldata) {
			if(data.contains("tyss")) 
			{
				count++;
				break;
			}
		}
		if(count==1) {
			javautility.printStatement("The data is present and Test case is pass");
		}
		else
			javautility.printStatement("data is not present and test case is fail");
		//logout action
		commonpage.logoutAction();


	}

}
