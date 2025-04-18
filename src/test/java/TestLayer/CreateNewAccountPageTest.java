package TestLayer;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;
import PageLayer.CreateNewAccountPage;

public class CreateNewAccountPageTest extends BaseClass{
	
	private static CreateNewAccountPage createnewaccountpage;
	@BeforeTest
	public void setUp()
	{
		BaseClass.initialization();
	}

	@Test
	public void validateCreateNewUser()
	{
		 createnewaccountpage= new CreateNewAccountPage();
		 createnewaccountpage.createNewUserFunctionality("rk@gmail.com", "Rushi", "Khalate", "Pune", "Baramati", "Pune", "252633", "India");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
