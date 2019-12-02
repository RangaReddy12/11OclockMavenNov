package DriverFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DataDriven {
String inputpath="D:\\4Oclock_Framework\\11oClcock_Maven\\TestInput\\Logindata.xlsx";
String outputpath="D:\\4Oclock_Framework\\11oClcock_Maven\\TestOut\\LoginResults.xlsx";
WebDriver driver;
FileInputStream fi;
FileOutputStream fo;
XSSFWorkbook wb;
XSSFSheet ws;
XSSFRow row;
ExtentReports report;
ExtentTest test;
File screen;
@BeforeTest
public void setUp()
{
	//generate html report
report=new ExtentReports("./Reports/Login.html");
System.setProperty("webdriver.chrome.driver", "D:\\4Oclock_Framework\\11oClcock_Maven\\Drivers\\chromedriver.exe");
driver=new ChromeDriver();
}
@Test
public void verifyLogin()throws Throwable
{
fi=new FileInputStream(inputpath);
wb=new XSSFWorkbook(fi);
ws=wb.getSheet("Login");
row=ws.getRow(0);
int rc=ws.getLastRowNum();
int cc=row.getLastCellNum();
Reporter.log("No of rows are::"+rc+"  "+"no of columns are::"+cc,true);
for(int i=1;i<=rc;i++)
{
	//start test case to generate  reports
test=report.startTest("Verif Login Test");
driver.get("https://opensource-demo.orangehrmlive.com/");
driver.manage().window().maximize();
String username=ws.getRow(i).getCell(0).getStringCellValue();
String password=ws.getRow(i).getCell(1).getStringCellValue();
//login to app
driver.findElement(By.name("txtUsername")).sendKeys(username);
driver.findElement(By.name("txtPassword")).sendKeys(password);
driver.findElement(By.name("Submit")).sendKeys(Keys.ENTER);
Thread.sleep(4000);
if(driver.getCurrentUrl().contains("dash"))
{
screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(screen, new File("D:\\4Oclock_Framework\\Selenium_Frameworks\\Screens\\Iteration"+i+"Loginpage.png"));
Reporter.log("Login Success",true);
//write as login success into results column
ws.getRow(i).createCell(2).setCellValue("Login Success");
//write as pass into status column
ws.getRow(i).createCell(3).setCellValue("Pass");
test.log(LogStatus.PASS, "Login Success");
}
else
{
screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(screen, new File("D:\\4Oclock_Framework\\Selenium_Frameworks\\Screens\\Iteration"+i+"Loginpage.png"));
Reporter.log("Login Fail",true);
//get error message
String message=driver.findElement(By.id("spanMessage")).getText();
//write as error message into results column
ws.getRow(i).createCell(2).setCellValue(message);
ws.getRow(i).createCell(3).setCellValue("Fail");
test.log(LogStatus.FAIL, message);
}
report.endTest(test);
report.flush();
}
fi.close();
fo=new FileOutputStream(outputpath);
wb.write(fo);
fo.close();
wb.close();
}
@AfterTest
public void tearDown()
{
	driver.close();
}
}
















