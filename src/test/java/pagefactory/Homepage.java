package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Homepage extends TestBase {

@FindBy(linkText="Log in")
static WebElement link_login;

public Homepage() {
	PageFactory.initElements(driver, this);
}

public void clickLoginLink() {
	link_login.click();
}

}
