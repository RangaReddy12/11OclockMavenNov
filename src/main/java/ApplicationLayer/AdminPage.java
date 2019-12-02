package ApplicationLayer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class AdminPage {
	//maintain Repository for login
	@FindBy(name="txtUsername")
	WebElement username_txtbox;
	@FindBy(name="txtPassword")
	WebElement password_txtbox;
	@FindBy(name="Submit")
	WebElement Login_btn;
	//method for login
	public void verifyLogin(String username,String password)throws Throwable
	{
		username_txtbox.sendKeys(username);
		password_txtbox.sendKeys(password);
		Login_btn.click();
		Thread.sleep(3000);
	}
}
