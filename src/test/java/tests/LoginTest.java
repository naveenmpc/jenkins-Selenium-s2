package tests;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pagefactory.Homepage;
import pagefactory.Loginpage;
import pagefactory.TestBase;
import utilities.Excelread;
import utilities.MyListener;

@Listeners(value={MyListener.class})
public class LoginTest extends TestBase {
	WebDriver driver;
	Homepage h;
	Loginpage l;
	Excelread e = new Excelread();
	
	@DataProvider
	public Object[][] loginData() throws IOException{
    int LastRow = e.getLastRow("C:\\Users\\mnave\\Downloads\\Testdata.xlsx\\","Sheet1");
		Object[][] mydata = new Object[LastRow+1][2];
		for(int i=0;i<=LastRow;i++) {
	            mydata[i][0] = e.readExcel("C:\\Users\\mnave\\Downloads\\Testdata.xlsx\\", "Sheet1", i, 0);
			mydata[i][1] = e.readExcel("C:\\Users\\mnave\\Downloads\\Testdata.xlsx\\", "Sheet1", i, 1);
		}
		return mydata;
	}
	
	@Test(dataProvider="loginData")
	public void testLogin(String u, String p) {
		h.clickLoginLink();
		l.enterLoginDetails(u, p);
		try {
			l.clickLogout();
		}catch(Exception e) {
			Assert.fail("Sign Out is not Present");
		}
	}
	
	@BeforeTest
	public void setup() {
		getBrowser();
		h = new Homepage();
		l = new Loginpage();
	}

}