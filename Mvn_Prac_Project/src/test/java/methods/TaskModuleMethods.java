package methods;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import driver.DriverScript;
import locators.ObjectLocators;

public class TaskModuleMethods extends DriverScript implements ObjectLocators{

	/***************************************************************
	 * Method Name			: Create_Customer()
	 * 
	 ***************************************************************/
	
	public String Create_Customer(WebDriver oDriver, Map<String, String> data, ExtentTest test) {
		String strStatus = null;
		String custmrName = null;
		try
		{
				appInd.waitForElement(oDriver, objAddNew, "clickable", "", 10);
				strStatus+= appInd.clickObject(oDriver, objAddNew, test);
				
				appInd.waitForElement(oDriver, objAddNewCustmr, "clickable", "", 10);
				strStatus+= appInd.clickObject(oDriver, objAddNewCustmr, test);
				
				appInd.waitForElement(oDriver, objCreateCustmrTitle, "Text", "Create New Customer", 10);
				if(appInd.verifyText(oDriver, objCreateCustmrTitle, "Text", "Create New Customer", test)) {
					reports.writeResult(oDriver, "Pass", "Create User Box is opened sucessfully", test);
					
					strStatus+= appInd.setObject(oDriver, objEnterCustName, data.get("NEW_CN"), test);
					strStatus+= appInd.clickObject(oDriver, objcreateCustmrBtn, test);
					
					custmrName = data.get("NEW_CN");
					
					appInd.waitForElement(oDriver, By.xpath("//div[text()="+"'"+custmrName+"'"+"]"), "visible", "", 10);
					strStatus+= appInd.verifyElementExist(oDriver, By.xpath("//div[text()="+"'"+custmrName+"'"+"]"), test);
					
					if(strStatus.contains("false")){
						reports.writeResult(oDriver, "Fail", "Failed to create the customer in the actiTime", test);
						return null;
						
					}else {
						reports.writeResult(oDriver, "Pass", "Customer is created successful", test);
						return custmrName;
					}
				}else {
					reports.writeResult(oDriver, "Fail", "Failed to open Create User", test);
					return null;
				}
		}catch(Exception e)
		{
			reports.writeResult(oDriver, "Exception", "Exception in Create_Customer() :"+e, test);
			return null;
		}finally {
			strStatus = null;
			custmrName = null;
		}
	}
	
	/***************************************************************
	 * Method Name			: Create_Project()
	 * Details				: Create Project
	 * 
	 ***************************************************************/
	
	public String Create_Project(WebDriver oDriver, Map<String, String> data, Map<String, String> data1, String CustName, ExtentTest test) {
		String strStatus = null;
		String projectName = null;
		try
		{
			if(appInd.verifyOptionalElementExist(oDriver, objAllCustNamesN, test)) {
			strStatus+= appInd.clickObject(oDriver, objAllCustNamesN, test);
			}
			appInd.waitForElement(oDriver, objAddNew, "clickable", "", 10);
			strStatus+= appInd.clickObject(oDriver, objAddNew, test);
			
			appInd.waitForElement(oDriver, objAddNewProject, "clickable", "", 10);
			strStatus+= appInd.clickObject(oDriver, objAddNewProject, test);
			
			appInd.waitForElement(oDriver, objCreateNewProject, "Text", "Create New Project", 10);
			if(appInd.verifyText(oDriver, objCreateNewProject, "Text", "Create New Project", test)) {
				reports.writeResult(oDriver, "Pass", "Create New Project Box opened successfully", test);	
				strStatus+= appInd.setObject(oDriver, objEnterProjectName, data.get("NEW_P"), test);
				
				appInd.waitForElement(oDriver, objCustmrList_Click, "clickable", "", 10);
				strStatus+= appInd.clickObject(oDriver, objCustmrList_Click, test);
				
				
				if(CustName.isEmpty()) {
					strStatus+= appInd.clickObjectInTable(oDriver, By.xpath("//ul[@class='x-menu-list']//li/descendant::a"), data1.get("OLD_CN"), test);
					
					appInd.waitForElement(oDriver, By.xpath("//button[@class='x-btn-text'][text()="+"'"+data1.get("OLD_CN")+"'"+"]"), "visible", "", 10);
					if(appInd.verifyElementExist(oDriver, By.xpath("//button[@class='x-btn-text'][text()="+"'"+data1.get("OLD_CN")+"'"+"]"), test)) {
						reports.writeResult(oDriver, "Pass", "The element '"+data1.get("OLD_CN")+"' is selected successfully", test);
						strStatus+= appInd.clickObject(oDriver, objCreateProjectBtn, test);
						projectName = data1.get("NEW_P");
					}else {
						reports.writeResult(oDriver, "Fail", "The element '"+data1.get("OLD_CN")+"' is failed to select", test);
						strStatus+= false;
					}
				}else {
					strStatus+= appInd.clickObjectInTable(oDriver, By.xpath("//ul[@class='x-menu-list']//li/descendant::a"), CustName, test);
					
					appInd.waitForElement(oDriver, By.xpath("//button[@class='x-btn-text'][text()="+"'"+CustName+"'"+"]"), "visible", "", 10);
					if(appInd.verifyText(oDriver, By.xpath("//button[@class='x-btn-text'][text()="+"'"+CustName+"'"+"]"), "Text", CustName, test)) {
						reports.writeResult(oDriver, "Pass", "The element '"+CustName+"' is selected successfully", test);
						strStatus+= appInd.clickObject(oDriver, objCreateProjectBtn, test);
						projectName = data.get("NEW_P");
					}else {
						reports.writeResult(oDriver, "Fail", "The element '"+CustName+"' is failed to select", test);
						strStatus+= false;
					}
				}	
				
				appInd.waitForElement(oDriver, By.xpath("//div[@class='title ellipsis' and text()="+"'"+projectName+"'"+"]"), "visible", "", 10);
				strStatus+= appInd.verifyElementExist(oDriver, By.xpath("//div[@class='title ellipsis' and text()="+"'"+projectName+"'"+"]"), test);
					
				if(strStatus.contains("false")){
					reports.writeResult(oDriver, "Fail", "Failed to create the Project in the actiTime", test);
					return null;	
				}else {
					reports.writeResult(oDriver, "Pass", "Project is created successful", test);
					return projectName;
				}
			}else {
				reports.writeResult(oDriver, "Fail", "Failed to open Create New Project Box", test);
				return null;
			}
	
		}catch(Exception e)
		{
			reports.writeResult(oDriver, "Exception", "Exception in create Project", test);
			return null;
		}finally {
			strStatus = null;
			projectName = null;
		}
		
	}
	/***************************************************************
	 * Method Name			: Open_Task_Menu()
	 * 
	 ***************************************************************/
	
	public boolean Open_Task_Menu(WebDriver oDriver, ExtentTest test) {
		try {
			
			appInd.waitForElement(oDriver, objTaskMenu, "clickable", "", 20);
			appInd.jsClickObject(oDriver, objTaskMenu, test);
			appInd.waitForElement(oDriver, objTaskMenuPageTitle, "Text", "Tasks of", 10);
			
			if(appInd.verifyText(oDriver, objTaskMenuPageTitle, "Text", "Tasks of", test)) {
				reports.writeResult(oDriver, "Pass", "Task Menu page opened successfully", test);
				return true;
			}else {
				reports.writeResult(oDriver, "Fail", "Failed to open Task Menu page", test);
				return false;
			}
		}catch(Exception e)
		{
			reports.writeResult(oDriver, "Exception", "Exception in Open_Task_Menu() : "+e, test);
			return false;
		}
	}
	
	/******************************************************************
	 * Method Name				: Delete_Customer
	 * 
	 ******************************************************************/
	
	public boolean Delete_Customer(WebDriver oDriver, Map<String, String> data, String strValue, ExtentTest test) {
		String strStatus = null;
		try
		{
			oDriver.navigate().refresh();
			appInd.waitForElement(oDriver, objAllCustmrsRefresh, "visible", "", 30);
			if(strValue.isEmpty()) {
				strStatus+= appInd.clickObject(oDriver, By.xpath("//div[@class='title' and contains(text(), "+"'"+data.get("DLT_C")+"'"+")]/following-sibling::div"), test);
				appInd.waitForElement(oDriver, objC_ActionsBtn, "clickable", "", 10);
				strStatus+= appInd.jsClickObject(oDriver, objC_ActionsBtn, test);
				appInd.waitForElement(oDriver, objC_DeleteBtn, "clickable", "", 10);
				strStatus+= appInd.clickObject(oDriver, objC_DeleteBtn, test);
				appInd.waitForElement(oDriver, objC_PermntDltBtn, "clickable", "", 10);
				strStatus+= appInd.jsClickObject(oDriver, objC_PermntDltBtn, test);
				appInd.waitForElement(oDriver, By.xpath("//div[@class='itemsContainer']/div//div[contains(text(),"+"'"+data.get("DLT_C")+"'"+")]"), "invisible", "", 10);
				if(appInd.verifyOptionalElementExist(oDriver, By.xpath("//div[@class='itemsContainer']/div//div[contains(text(),"+"'"+data.get("DLT_C")+"'"+")]"), test)) {
					strStatus+= false;
				}else {
					strStatus+= true;
				}
			}else {
				strStatus+= appInd.clickObject(oDriver, By.xpath("//div[@class='title' and contains(text(), "+"'"+strValue+"'"+")]/following-sibling::div"), test);
				appInd.waitForElement(oDriver, objC_ActionsBtn, "visible", "", 10);
				strStatus+= appInd.jsClickObject(oDriver, objC_ActionsBtn, test);
				appInd.waitForElement(oDriver, objC_DeleteBtn, "visible", "", 10);
				strStatus+= appInd.clickObject(oDriver, objC_DeleteBtn, test);
				appInd.waitForElement(oDriver, objC_PermntDltBtn, "visible", "", 10);
				strStatus+= appInd.jsClickObject(oDriver, objC_PermntDltBtn, test);
				appInd.waitForElement(oDriver, By.xpath("//div[@class='itemsContainer']/div//div[contains(text(),"+"'"+strValue+"'"+")]"), "invisible", "", 10);
				if(appInd.verifyOptionalElementExist(oDriver, By.xpath("//div[@class='itemsContainer']/div//div[contains(text(),"+"'"+strValue+"'"+")]"), test)) {
					strStatus+= false;
				}else {
					strStatus+= true;
				}
			}
			
			if(strStatus.contains("false")){
				reports.writeResult(oDriver, "Fail", "Failed to delete Customer", test);
				return false;	
			}else {
				reports.writeResult(oDriver, "Pass", "Customer deleted successfully", test);
				return true;
			}
			
		}catch(Exception e)
		{
			reports.writeResult(oDriver, "Exception", "Exception in  Delete_Customer () : "+e, test);
			return  false;
		}
	}

	
	
	/******************************************************************
	 * Method Name				: Delete_Project
	 * 
	 ******************************************************************/
	
	public boolean Delete_Project(WebDriver oDriver, Map<String, String> data, String strValue, ExtentTest test) {
		String strStatus = null;
		try
		{
			
			if((appInd.verifyOptionalElementExist(oDriver, objOptionalExpandBtn, test))) {
				strStatus+= appInd.clickObject(oDriver, objP_ExpandBtn, test);
			}
			
			oDriver.navigate().refresh();
			appInd.waitForElement(oDriver, objAllCustmrsRefresh, "visible", "", 30);
			
			if(strValue.isEmpty()) {
				
			strStatus+= appInd.clickObject(oDriver, By.xpath("//div[@class='node projectNode notSelected']/div[contains(text(),"+"'"+data.get("DLT_P")+"'"+")]/following-sibling::div"), test);
			appInd.waitForElement(oDriver, objP_ActionsBtn, "clickable", "", 10);
			strStatus+= appInd.jsClickObject(oDriver, objP_ActionsBtn, test);
			appInd.waitForElement(oDriver, objP_DeleteBtn, "clickable", "", 10);
			strStatus+= appInd.clickObject(oDriver, objP_DeleteBtn, test);
			appInd.waitForElement(oDriver, objP_PermntDltBtn, "clickable", "", 10);
			strStatus+= appInd.clickObject(oDriver, objP_PermntDltBtn, test);
			
			appInd.waitForElement(oDriver, By.xpath("//div[@class='node customerNode notSelected']//following-sibling::div//div[contains(text(),"+"'"+data.get("DLT_P")+"'"+")]"), "invisible", "", 10);
			if(appInd.verifyOptionalElementExist(oDriver, By.xpath("//div[@class='node customerNode notSelected']//following-sibling::div//div[contains(text(),"+"'"+data.get("DLT_P")+"'"+")]"), test)) {
				strStatus+= false;
			}else {
				strStatus+= true;
			}
			}else {
				strStatus+= appInd.clickObject(oDriver, By.xpath("//div[@class='node projectNode notSelected']/div[contains(text(),"+"'"+strValue+"'"+")]/following-sibling::div"), test);
				appInd.waitForElement(oDriver, objP_ActionsBtn, "clickable", "", 10);
				strStatus+= appInd.jsClickObject(oDriver, objP_ActionsBtn, test);
				appInd.waitForElement(oDriver, objP_DeleteBtn, "clickable", "", 10);
				strStatus+= appInd.clickObject(oDriver, objP_DeleteBtn, test);
				appInd.waitForElement(oDriver, objP_PermntDltBtn, "clickable", "", 10);
				strStatus+= appInd.clickObject(oDriver, objP_PermntDltBtn, test);

				appInd.waitForElement(oDriver, By.xpath("//div[@class='node customerNode notSelected']//following-sibling::div//div[contains(text(),"+"'"+strValue+"'"+")]"), "invisible", "", 10);
				if(appInd.verifyOptionalElementExist(oDriver, By.xpath("//div[@class='node customerNode notSelected']//following-sibling::div//div[contains(text(),"+"'"+strValue+"'"+")]"), test)) {
					strStatus+= false;
				}else {
					strStatus+= true;
				}
			}

			if(strStatus.contains("false")){
				reports.writeResult(oDriver, "Fail", "Failed to delete Project", test);
				return false;	
			}else {
				reports.writeResult(oDriver, "Pass", "Project deleted successfully", test);
				return true;
			}
			
		}catch(Exception e)
		{
			reports.writeResult(oDriver, "Exception", "Exception in  Delete_Project () : "+e, test);
			return  false;
		}
	}
	
	/******************************************************************
	 * Method Name				: moveProject
	 * 
	 ******************************************************************/
	public boolean moveProject(WebDriver oDriver, Map<String, String> data, ExtentTest test) {
		String strStatus = null;
		try
		{
			if((appInd.verifyOptionalElementExist(oDriver, objOptionalExpandBtn, test))) {
				strStatus+= appInd.clickObject(oDriver, objP_ExpandBtn, test);
			}
			strStatus+= appInd.clickObject(oDriver, By.xpath("//div[contains(text(),"+"'"+data.get("FROM_CN")+"'"+")]/parent::div[@class='node customerNode notSelected']/following-sibling::div[@class='node projectNode notSelected']/div[contains(text(),"+"'"+data.get("MOVE_P")+"'"+")]/following-sibling::div"), test);
			appInd.waitForElement(oDriver, objP_ActionsBtn, "visible", "", 10);
			strStatus+= appInd.jsClickObject(oDriver, objP_ActionsBtn, test);
			appInd.waitForElement(oDriver, objP_MoveBtn, "visible", "", 10);
			strStatus+= appInd.clickObject(oDriver, objP_MoveBtn, test);
			
			appInd.waitForElement(oDriver, objP_MoveToTitle, "text", "Move project to another customer:", 10);
			if(appInd.verifyElementExist(oDriver, objP_MoveToTitle, test)) {
				reports.writeResult(oDriver, "Pass", "MoveTo Dialogue Box opened successfully", test);
				strStatus+= appInd.clickObject(oDriver, objP_MoveToDropDown, test);
				
				strStatus+= appInd.jsClickObject(oDriver, By.xpath("//div[@class='dropdownContainer simpleListMenu']/div/div/div[@class='itemsContainer']/div[text()="+"'"+data.get("TO_CN")+"'"+"]"), test);
				
				if(appInd.verifyText(oDriver, By.xpath("//div[@class='simpleListMenuButton emptyList notEmpty']/div[contains(text(),"+"'"+data.get("TO_CN")+"'"+")]"), "Text", data.get("TO_CN"), test)) {
					reports.writeResult(oDriver, "Pass", "Customer : "+"'"+data.get("TO_CN")+"'"+"is selected successfully", test);
					strStatus+= appInd.clickObject(oDriver, objP_finalMoveBtn, test);
					
					appInd.waitForElement(oDriver, By.xpath("//div[contains(text(),"+"'"+data.get("TO_CN")+"'"+")]/parent::div[@class='node customerNode notSelected']/following-sibling::div/div[contains(text(),"+"'"+data.get("MOVE_P")+"'"+")]"), "visible", "", 5);
					if(appInd.verifyElementExist(oDriver, By.xpath("//div[contains(text(),"+"'"+data.get("TO_CN")+"'"+")]/parent::div[@class='node customerNode notSelected']/following-sibling::div/div[contains(text(),"+"'"+data.get("MOVE_P")+"'"+")]"), test)) {
						strStatus+= true;
					}else {
						strStatus+= false;
					}
				}else {
					reports.writeResult(oDriver, "Fail", "Failed to select the Customer: "+"'"+data.get("TO_CN")+"'"+"", test);
					strStatus+= false;
				}
			}else {
				reports.writeResult(oDriver, "Fail", "Failed to open MoveTo Dialogue Box", test);
				strStatus+= false;
			}
			
			
			if(strStatus.contains("false")){
				reports.writeResult(oDriver, "Fail", "Failed to Move Project", test);
				return false;	
			}else {
				reports.writeResult(oDriver, "Pass", "Project moved successfully", test);
				return true;
			}
			
		}catch(Exception e)
		{
			reports.writeResult(oDriver, "Exception", "Exception in  moveProject() : "+e, test);
			return  false;
		}
	}
	
}
