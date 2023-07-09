package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	//Constructor
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	//identifying webElements and locators of account Registration page
	
	
	//personal details
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txt_FirstName;
	@FindBy(xpath="//input[@id='input-lastname']")  WebElement txt_LastName;
	@FindBy(xpath="//input[@id='input-email']") WebElement txt_email;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txt_telephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement txt_Password;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txt_ConfirmPass;
	
	@FindBy(name ="agree") WebElement chkBox_CheckedPolicy;
	@FindBy(xpath="//input[@value='Continue']") WebElement btn_Continue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement msg_Confirmation_text;
	
	
	//Corresponding Action Methods
	
	public void setFirstName(String fname)
	{
		txt_FirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txt_LastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void setTelephone(String telno)
	{
		txt_telephone.sendKeys(telno);
	}
	
	public void setPassword(String pwd)
	{
		txt_Password.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String confirmpwd)
	{
		txt_ConfirmPass.sendKeys(confirmpwd);
	}
	
	public void clickCheckBox()
	{
		chkBox_CheckedPolicy.click();
	}
	
	public void clickButtonContinue()
	{
		btn_Continue.click();
	}
	
	public String getConfirmationMessage()
	{
		try {
		String actual_text=msg_Confirmation_text.getText();
		return actual_text;
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
}

