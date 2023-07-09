package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{

	@Test(groups= {"Sanity","Master"})
	public void test_Login()
	{
		logger.info("********Starting TC_002_LoginTest test****************");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLinkLogin();
		
		LoginPage lp=new LoginPage(driver);
		
		logger.info("Providing the login Details................");
		lp.setLoginEmail(rb.getString("email"));
		lp.setLoginPassword(rb.getString("password"));
		
		lp.clickLoginButton();
		logger.info("Clicked on Login button");
		
		//validation
		MyAccountPage mAp=new MyAccountPage(driver);
		boolean targetPage=mAp.isMyAccountPageExists();
		logger.info("Validation started..................");
		Assert.assertEquals(targetPage, true,"Invalid Login Data");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***********Finished TC_002_LoginTest test****************");
	}
}
