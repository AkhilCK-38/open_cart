package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{

	
	
	//here i am using dataProviderClass name bcoz dataProvider method is in some other class it can't access outside class
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void test_loginDDT(String email,String pwd,String exp)
	{
		try
		{
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLinkLogin();
		
		LoginPage lp= new LoginPage(driver);
		lp.setLoginEmail(email);
		lp.setLoginPassword(pwd);
		
		lp.clickLoginButton();
		
		//validations
		MyAccountPage macc= new MyAccountPage(driver);
		boolean status=macc.isMyAccountPageExists();
		
		//if the credentials are valid , and myAccount page exists then results is pass
		//if the credentials are valid , and my Account page not exists then result is fail
		//if the credentails are invalid, and my account page opens than also result is fail bcoz i am expecting not to open
		//if the credentails are invalid ,and my account page not opens then result is pass
		
		if(exp.equals("Valid"))
		{
			if(status == true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				//Assert.fail();
				//OR
				Assert.assertTrue(false);
			}	
		}
		
		if(exp.equals("Invalid"))
		{
			//if status is true than only it will enter below loop
			if(status == true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
	}
	
	catch(Exception e)
	{
		Assert.fail();
	}
	}
}
