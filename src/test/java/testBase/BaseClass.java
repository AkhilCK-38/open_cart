package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

public class BaseClass {

	public ResourceBundle rb;// to read config.properties
	public static WebDriver driver;
	public Logger logger;
	
	
	
	@BeforeClass(groups= {"Master","Regression","Sanity"})
	@Parameters("browser")
	public void setup(String br)
	{
		rb=ResourceBundle.getBundle("config"); 
		/*
		//we have a chromeOptions to disable the text "Chrome is being controlled by automated test software"
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		driver= new ChromeDriver(options);
		*/
		
		
		//getClass() returns the runtime class of the object "this".
		logger=LogManager.getLogger(this.getClass());
		
		if(br.equals("Chrome"))
		{
		driver= new ChromeDriver();
		}
		else if(br.equals("Edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver= new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Master","Regression","Sanity"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomString()
	{
		String random_string1=RandomStringUtils.randomAlphabetic(5);
		return random_string1;
	}
	
	//for telephone numbers or OTPs, just change the number of digits u want
	public String randomNumber()
	{
		String random_number=RandomStringUtils.randomNumeric(10);
		return random_number;
	}
	
	//for generating alphanumeric characters
	
	public String randomAlphaNumeric()
	{
		//String random_alphNumeric=RandomStringUtils.randomAlphanumeric(8);
		String random_alpha=RandomStringUtils.randomAlphabetic(5);
		String random_num=RandomStringUtils.randomNumeric(4);		
		return (random_alpha+"@"+random_num);
	}
	
	public String captureScreen(String tname) throws IOException
	{
		/*
		SimpleDateFormat df= new SimpleDateFormat("yyyyMMddhhmmss");
		Date dt= new Date();
		String timeStamp=df.format(dt);
		*/
		//OR writing 3 lines of code in one line
		String timeStamp= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takeScreenshot= (TakesScreenshot) driver;
		File source=takeScreenshot.getScreenshotAs(OutputType.FILE);
		//File destination = new File(System.getProperty("user.dir")+"\\screenshots\\"+timeStamp+".png");
		String destination = System.getProperty("user.dir")+"\\screenshots\\"+timeStamp+".png";
		//FileUtils.copyFile(source, destination);  //sir method not working
		//Files.copy(source, destination);
		
		try
		{
		FileUtils.copyFile(source, new File(destination));  
		}catch(Exception e)
		{
			e.getMessage();
		}
		return destination;
	}
}
