package dec6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailLogin {

	public static void main(String[] args) throws Throwable {
	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
driver.get("http://gmail.com");
driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
driver.manage().window().maximize();
driver.findElement(By.name("identifier")).sendKeys("pranga2010");
driver.findElement(By.className("CwaK9")).click();

driver.findElement(By.name("password")).sendKeys("pranga2010");
	}

}
