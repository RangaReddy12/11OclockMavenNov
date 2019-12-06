package dec5;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeTest;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
public class Using_DataProvider {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	DesiredCapabilities cap;
	String node="http://localhost:5550/wd/hub";
@Parameters({"browser"})	
 @BeforeTest
 public void beforeTest(String brw) throws Throwable{
	report=new ExtentReports("./Report/Dataprovider.html") ;
	if(brw.equalsIgnoreCase("chrome"))
	{
		System.out.println("Executing on chrome browser");
		cap=new DesiredCapabilities();
		cap.setBrowserName("chrome");
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver=new RemoteWebDriver(new URL(node), cap);	
	}
	else if(brw.equalsIgnoreCase("firefox"))
	{
		System.out.println("Executing on Firefox browser");
		cap=new DesiredCapabilities();
	cap.setBrowserName("firefox");
	System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
	driver=new RemoteWebDriver(new URL(node), cap);		
	  }
	else
	{
	System.out.println("Browser is not matching");	
	}
}
  @Test(dataProvider = "supplyData")
  public void verifyLogin(String user,String pass) throws Throwable
  {
test=report.startTest("Verify Login Test");  
driver.get("http://orangehrm.qedgetech.com/");
driver.manage().window().maximize();
driver.findElement(By.name("txtUsername")).sendKeys(user);
driver.findElement(By.name("txtPassword")).sendKeys(pass);
driver.findElement(By.name("Submit")).sendKeys(Keys.ENTER);
Thread.sleep(3000);

if(driver.getCurrentUrl().contains("dash"))
{
test.log(LogStatus.PASS, "Login Success");	
Reporter.log("Login Success",true);
}
else
{
String message=driver.findElement(By.id("spanMessage")).getText();	
Reporter.log(message,true);
test.log(LogStatus.FAIL, message);
}
}
  @DataProvider
  public Object[][] supplyData() {
  Object[][]login=new Object[4][2];//4 rows 2 columns
  login[0][0]="Admin";
  login[0][1]="Qedge123!@#";
  
  login[1][0]="test";
  login[1][1]="admin";
  
  login[2][0]="test";
  login[2][1]="test";
  
  login[3][0]="test";
  login[3][1]="test";
    return login;
  }
 

  @AfterTest
  public void afterTest() 
  {
	  report.endTest(test);
	  report.flush();
	  driver.close();
  }
  

}













