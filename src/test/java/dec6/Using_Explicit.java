package dec6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Using_Explicit {

	public static void main(String[] args) throws Throwable {
	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
driver.get("http://gmail.com");
driver.manage().window().maximize();
WebDriverWait wait=new WebDriverWait(driver, 300);
//wait until username text box is visible
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
driver.findElement(By.name("identifier")).sendKeys("pranga2010");
//wait until element to be clickable
wait.until(ExpectedConditions.elementToBeClickable(By.className("CwaK9")));

driver.findElement(By.className("CwaK9")).click();
//wait until username text box is visible
wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
driver.findElement(By.name("password")).sendKeys("pranga2010");
	}

}















