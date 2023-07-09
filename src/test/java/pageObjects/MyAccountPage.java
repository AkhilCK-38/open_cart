package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	//webelements
	
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement msgHeading;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement lnk_Logout;
	
	//methods
	
	public boolean isMyAccountPageExists()
	{
		try {
		boolean status_MyAccountLabel=msgHeading.isDisplayed();
		return status_MyAccountLabel;
		}
		catch(Exception e)
		{
		return false;
		}
	}
	
	public void clickLogout()
	{
		lnk_Logout.click();
	}
}
