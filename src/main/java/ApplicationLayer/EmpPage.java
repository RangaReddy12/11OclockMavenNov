package ApplicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class EmpPage {
WebDriver driver;
Actions ac;
public EmpPage(WebDriver driver)
{
	this.driver=driver;
}
//Repository for Emp page
@FindBy(id="menu_pim_viewPimModule")
WebElement Click_pim;
@FindBy(id="btnAdd")
WebElement Click_add;
@FindBy(css="#firstName")
WebElement fname_txxbox;
@FindBy(css="#lastName")
WebElement lname_txxbox;
@FindBy(css="#employeeId")
WebElement eid_txxbox;
@FindBy(css="#btnSave")
WebElement Click_save;
public void verifyAddEmp(String fname,String lname,String eid)throws Throwable
{
ac=new Actions(driver);
ac.moveToElement(Click_pim).click().perform();
Thread.sleep(4000);
ac.moveToElement(Click_add).click().perform();
Thread.sleep(4000);
fname_txxbox.sendKeys(fname);
lname_txxbox.sendKeys(lname);
eid_txxbox.clear();
eid_txxbox.sendKeys(eid);
ac.moveToElement(Click_save).click().perform();
}

}


















