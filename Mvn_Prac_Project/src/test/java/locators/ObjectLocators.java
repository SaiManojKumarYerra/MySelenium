package locators;

public interface ObjectLocators {
	final String objUserNameEdit = "//input[@placeholder='Username']";
	final String objPasswordEdit = "//input[@name='pwd']";
	final String objLoginBtn = "//a[@id='loginButton']";
	final String objHomePageTitle = "//td[@class='pagetitle']";
	final String objShortcutWindow = "//div[@style='display: block;']";
	final String objShotcutCloseBtn = "//div[@id='gettingStartedShortcutsMenuCloseId']";
	final String objUserMenu = "//div[text()='USERS']";
	final String objAddUserBtn = "//div[text()='Add User']";
	final String objAddUserWindow = "//span[text()='Add User']";
	final String objFirstNameEdit = "//input[@name='firstName']";
	final String objLastNameEdit = "//input[@name='lastName']";
	final String objEmailEdit = "//input[@name='email']";
	final String objUser_UNEdit = "//input[@name='username']";
	final String objUser_PwdEdit = "//input[@name='password']";
	final String objUser_RetypePWdEdit = "//input[@name='passwordCopy']";
	final String objCreateUserBtn = "//span[text()='Create User']";
	final String objDeleteUserBtn = "//button[@id='userDataLightBox_deleteBtn']";
	final String objLogoutBtn = "//a[@id='logoutLink']";
	final String objLoginHeader = "//td[@id='headerContainer']";
	
	final String objTaskMenu = "//a[@class ='content tasks']";
	final String objTaskMenuPageTitle = "//div[@class='navigationLinks']"; //validation
	final String objAddNew = "//div[text() ='Add New']";
	final String objAddNewCustmr = "//div[text() ='+ New Customer']";
	final String objCreateCustmrTitle = "//span[@id='customerLightBox_titlePlaceholder']"; //validation
	final String objEnterCustName = "//input[@id='customerLightBox_nameField']";
	final String objcreateCustmrBtn ="//span[text()='Create Customer']";
	final String objAllCustNamesN = "//div[@class='node allCustomersNode notSelected']";
	final String objAllCustNamesY = "//div[@class='node allCustomersNode selected']";
	final String objAddNewProject = "//div[text() ='+ New Project']";
	final String objCreateNewProject = "//span[@id='projectPopup_titlePlaceholder']"; //validation
	final String objEnterProjectName ="//input[@id='projectPopup_projectNameField']";
	final String objCustmrList_Click = "//button[contains(text(),'-- Please Select Customer to Add Project for  --')]";
	final String objCreateProjectBtn ="//div[@id='projectPopup_commitBtn']";
	
	final String objC_ActionsBtn = "//div[@class='customerNamePlaceHolder']/following-sibling::div";
	final String objC_DeleteBtn = "//div[@class='edit_customer_sliding_panel sliding_panel']//div[@class='deleteButton']";
	final String objC_PermntDltBtn = "//span[@id='customerPanel_deleteConfirm_submitTitle']";
	
	final String objOptionalExpandBtn = "//div[@class='collapseAllButton']/ancestor::div[@class='customersProjectsTree']";
	final String objP_ExpandBtn = "//div[@class='collapseAllButton']";
	final String objP_ActionsBtn = "//div[@class='projectNamePlaceholder']/following-sibling::div[@class='actions']";
	final String objP_DeleteBtn = "//div[@class='edit_project_sliding_panel sliding_panel']//div[@class='deleteButton']";
	final String objP_PermntDltBtn = "//span[@id='projectPanel_deleteConfirm_submitTitle']";
	
	final String objP_MoveBtn ="//div[@class='edit_project_sliding_panel sliding_panel']/div[@class='dropdownContainer actionsMenu']/div/div[@class='moveButton']";
	final String objP_MoveToTitle = "//div[text()='Move project to another customer:']";
	final String objP_MoveToDropDown = "//div[@class='simpleListMenuButton emptyList emptySelection notEmpty']";
	final String objP_finalMoveBtn = "//div[@class='moveToDialog moveEnabled']/div[@class='buttonsContainer']/div[@class='move button']";
	
}
