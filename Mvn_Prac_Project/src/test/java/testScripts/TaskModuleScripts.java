package testScripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import driver.DriverScript;

public class TaskModuleScripts extends DriverScript {
	/**********************************************
	 * Script name 		: TS_Login_CreateCustomerWithProject_DeleteCustomer_Logout()
	 * 
	 * Calling-1		: Delete the created Customer along with project.
	 * Calling-2		: Delete the existing Customer
	 *
	 ***********************************************/
	public boolean TS_Login_CreateCustomerWithProject_DeleteCustomer_Logout()
	{
		WebDriver oBrowser = null;
		String strStatus = null;
		Map<String, String> objData = null;
		String customerName = null;
		try {
			
			test = extent.startTest("TS_Login_CreateCustomerWithProject_DeleteCustomer_Logout");
			
			objData = datatable.getTestData("TestData", "Script1", test);
			
			oBrowser = appInd.launchBrowser(objData.get("BrowserName"),test);
			strStatus+= appDep.navigateURL(oBrowser, objData.get("URL"),test);
			strStatus+= appDep.loginToApp(oBrowser, objData.get("UN"), objData.get("PWD"),test);
			strStatus+= taskMethods.Open_Task_Menu(oBrowser,test);
			customerName= taskMethods.Create_Customer(oBrowser, objData, test);
			strStatus+= taskMethods.Create_Project(oBrowser, objData, null, customerName, test);
			strStatus+= taskMethods.Delete_Customer(oBrowser, null, customerName, test);  //Calling-1
			strStatus+= taskMethods.Delete_Customer(oBrowser, objData, "", test);  //Calling-2
			strStatus+= appDep.logoutFromApp(oBrowser,test);
			strStatus+= appInd.closeBrowser(oBrowser,test);
			
			if(strStatus.contains("false")) {
				reports.writeResult(oBrowser,"Fail", "The test script TS_Login_CreateCustomer_Logout() was failed",test);
				return false;
			}else {
				reports.writeResult(oBrowser,"Pass", "The test script TS_Login_CreateCustomer_Logout() was Passed",test);
				return true;
			}
		}catch(Exception e)
		{
			reports.writeResult(oBrowser,"Exception", "Exception in TS_Login_CreateCustomer_Logout() script. "+ e,test);
			return false;
		}finally {
			reports.endExtentReport(test);
		}
	}
	
	/**********************************************
	 * Script name 	: TS_Login_CreateProjectforExistingCustomer_DeleteProject_Logout()
	 * 
	 * Calling-1		: Delete only created Project
	 * Calling-2		: Delete the existing Customer's Project
	 *
	 ***********************************************/
	public boolean TS_Login_CreateProjectforExistingCustomer_DeleteProject_Logout()
	{
		WebDriver oBrowser = null;
		String strStatus = null;
		Map<String, String> objData = null;
		String projectName = null;
		try {
			
			test = extent.startTest("TS_Login_CreateProjectforExistingCustomer_DeleteProject_Logout");
			
			objData = datatable.getTestData("TestData", "Script2", test);
			
			oBrowser = appInd.launchBrowser(objData.get("BrowserName"),test);
			strStatus+= appDep.navigateURL(oBrowser, objData.get("URL"),test);
			strStatus+= appDep.loginToApp(oBrowser, objData.get("UN"), objData.get("PWD"),test);
			strStatus+= taskMethods.Open_Task_Menu(oBrowser,test);
			projectName= taskMethods.Create_Project(oBrowser, objData, objData, "", test);
			strStatus+= taskMethods.Delete_Project(oBrowser, null, projectName, test); //Calling1
			strStatus+= taskMethods.Delete_Project(oBrowser, objData, "", test); //Calling2
			strStatus+= appDep.logoutFromApp(oBrowser,test);
			strStatus+= appInd.closeBrowser(oBrowser,test);
			
			if(strStatus.contains("false")) {
				reports.writeResult(oBrowser,"Fail", "The test script TS_Login_CreateProjectforExistingCustomer_Logout() was failed",test);
				return false;
			}else {
				reports.writeResult(oBrowser,"Pass", "The test script TS_Login_CreateProjectforExistingCustomer_Logout() was Passed",test);
				return true;
			}
		}catch(Exception e)
		{
			reports.writeResult(oBrowser,"Exception", "Exception in TS_Login_CreateProjectforExistingCustomer_Logout() script. "+ e,test);
			return false;
		}finally {
			reports.endExtentReport(test);
		}
	}

	/**********************************************
	 * Script name 	: TS_Login_CreateProjectforExistingCustomer_DeleteProject_Logout()
	 * 
	 * Calling-1		: Delete only created Project
	 * Calling-2		: Delete the existing Customer's Project
	 *
	 ***********************************************/
	public boolean TS_Login_MoveProject_Logout()
	{
		WebDriver oBrowser = null;
		String strStatus = null;
		Map<String, String> objData = null;
		try {
			
			test = extent.startTest("TS_Login_MoveProject_Logout");
			
			objData = datatable.getTestData("TestData", "Script3", test);
			
			oBrowser = appInd.launchBrowser(objData.get("BrowserName"),test);
			strStatus+= appDep.navigateURL(oBrowser, objData.get("URL"),test);
			strStatus+= appDep.loginToApp(oBrowser, objData.get("UN"), objData.get("PWD"),test);
			strStatus+= taskMethods.Open_Task_Menu(oBrowser,test);
			strStatus+= taskMethods.moveProject(oBrowser, objData, test);
			strStatus+= appDep.logoutFromApp(oBrowser,test);
			strStatus+= appInd.closeBrowser(oBrowser,test);
			
			if(strStatus.contains("false")) {
				reports.writeResult(oBrowser,"Fail", "The test script TS_Login_MoveProject_Logout() was failed",test);
				return false;
			}else {
				reports.writeResult(oBrowser,"Pass", "The test script TS_Login_MoveProject_Logout() was Passed",test);
				return true;
			}
		}catch(Exception e)
		{
			reports.writeResult(oBrowser,"Exception", "Exception in TS_Login_MoveProject_Logout() script. "+ e,test);
			return false;
		}finally {
			reports.endExtentReport(test);
		}
	}
	
}
