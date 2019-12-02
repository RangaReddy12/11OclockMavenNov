package ApplicationLayer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
public class UserPage {
	WebDriver driver;
	Actions ac;
public UserPage(WebDriver driver)
{
	this.driver=driver;
}
//Repository For user creation
@FindBy(id="menu_admin_viewAdminModule")
WebElement Click_admin;
@FindBy(id="menu_admin_UserManagement")
WebElement Click_usermngnt;
@FindBy(id="menu_admin_viewSystemUsers")
WebElement click_user;
@FindBy(id="btnAdd")
WebElement Clcik_add;
@FindBy(id="systemUser_employeeName_empName")
WebElement ename_txtbox;
@FindBy(id="systemUser_userName")
WebElement username_txtbox;
@FindBy(id="systemUser_password")
WebElement password_txtbox;
@FindBy(id="systemUser_confirmPassword")
WebElement cpassword_txtbox;
@FindBy(id="btnSave")
WebElement click_save;
public void verifyAddUser(String ename,String username,String password,String cpassword)
throws Throwable{
ac=new Actions(driver);
ac.moveToElement(Click_admin).perform();
Thread.sleep(3000);
ac.moveToElement(Click_usermngnt).perform();
Thread.sleep(3000);
ac.moveToElement(click_user).click().perform();
Thread.sleep(3000);
ac.moveToElement(Clcik_add).click().perform();
Thread.sleep(3000);
ename_txtbox.sendKeys(ename);
username_txtbox.sendKeys(username);
password_txtbox.sendKeys(password);
cpassword_txtbox.sendKeys(cpassword);
click_save.click();
Thread.sleep(4000);
}
}
















