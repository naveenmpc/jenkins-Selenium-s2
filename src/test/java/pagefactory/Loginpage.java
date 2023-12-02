package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage extends TestBase {

	
	@FindBy(id="Email")
	static WebElement TxtBox_Username;
	
	@FindBy(id="Password")
	static WebElement TxtBox_Password;
    
	@FindBy(xpath="//input[@value='Log in']")
	static WebElement Btn_Login;
	
	@FindBy(linkText="Log out")
	static WebElement Btn_logout;

	
public void enterLoginDetails(String u ,String p)
{
	TxtBox_Username.sendKeys(u);
	TxtBox_Password.sendKeys(p);
	Btn_Login.click();
}
	



public Loginpage()
{
	PageFactory.initElements(driver, this);
}

public void clickLogout()
{
	Btn_logout.click();
}


}