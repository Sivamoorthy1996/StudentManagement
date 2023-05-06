package org.sudentmanagement.timetable;

import org.testng.annotations.Test;
import org.tyys.genericUtility.BaseClass;

public class LoginPageSmokeTest extends BaseClass {
@Test
	public  void loginPageSmokeTest() {
		
        
        //login to the application
		loginpage.loginAction(username, password);
		
		
		
		
	}

}
