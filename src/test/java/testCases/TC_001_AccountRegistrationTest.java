package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;


//Currently this test case is not working bcoz the opencart application people have disabled the option of registering 
//to account using automated software u can do that only manually

public class TC_001_AccountRegistrationTest extends BaseClass{


	@Test(groups= {"Regression","Master"})
	public void test_account_Registration()
	{
		logger.debug("Application logs ...................");
		logger.info("*********Starting TC_001_AccountRegistrationTest****************");
		try{
	//creating an object of Homepage to access its methods
	HomePage hp=new HomePage(driver);
	hp.clickMyAccount();
	logger.info("Clicked on my account............");
	hp.clickRegister();
	logger.info("Clicked on Register............");
	
	//creating object of AccountRegistrationPage
	AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
	/*
	regpage.setFirstName("akhili990");
	regpage.setLastName("ckmas");
	regpage.setEmail("akhili990@gmail.com");
	regpage.setPassword("i99vat");
	regpage.clickCheckBox();
	regpage.clickButtonContinue();
	*/
	
	//above methods are hardcoded values which we can use only once , So i am using random characters
	logger.info("Dynamically sending values............");
	regpage.setFirstName(randomString().toUpperCase());
	regpage.setLastName(randomString().toLowerCase());
	regpage.setEmail(randomString()+"@gmail.com");
	regpage.setTelephone(randomNumber());
	//regpage.setPassword(randomAlphaNumeric());
	
	//currently in the above scenrio we have only 1 password field but usually there will be confirm password as well
	//in those case we can use below
	String password=randomAlphaNumeric();
	regpage.setPassword(password);
	regpage.setConfirmPassword(password);
	//regpage.setPassword(randomAlphaNumeric());
	//and one more for confirm password currently we don't have that feature in application
	//regpage.setConfirmPassword(randomAlphaNumeric());
	
	regpage.clickCheckBox();
	logger.info("Clicked on check box............");
	regpage.clickButtonContinue();
	logger.info("Clicked on continue button............");
	logger.info("validating expected message............");
	Assert.assertEquals(regpage.getConfirmationMessage(), "Your Account Has Been Created!");
	}
	catch(Exception e)
		{
		Assert.fail();
		e.getMessage();
		}
		
		logger.info("*********Finished TC_001_AccountRegistrationTest............");
	}
	
	
	
	
	
	
	
	
	
}
