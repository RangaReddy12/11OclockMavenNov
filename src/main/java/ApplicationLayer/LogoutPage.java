package ApplicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {
WebDriver driver;
Actions ac;
public LogoutPage(WebDriver driver)
{
	this.driver=driver;
}
@FindBy(css="#welcome")
WebElement click_welcome;
@FindBy(linkText="Logout")
WebElement Click_logout;
public void verifyLogout()throws Throwable
{
	ac=new Actions(driver);
ac.moveToElement(click_welcome).click().perform();
Thread.sleep(3000);
ac.moveToElement(Click_logout).click().perform();
Thread.sleep(3000);
}
}















