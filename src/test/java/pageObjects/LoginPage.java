package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	//constructor
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	//webelements
	
	@FindBy(xpath="//input[@id='input-email']") WebElement txt_LoginEmail;

	@FindBy(xpath="//input[@id='input-password']") WebElement txt_LoginPassword;
	
	@FindBy(xpath="//input[@value='Login']") WebElement btn_Login;
	
	//action methods
	
	public void setLoginEmail(String email)
	{
		txt_LoginEmail.sendKeys(email);
	}
	
	public void setLoginPassword(String pwd)
	{
		txt_LoginPassword.sendKeys(pwd);
	}
	
	public void clickLoginButton()
	{
		btn_Login.click();
	}
}
