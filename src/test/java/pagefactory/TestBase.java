package pagefactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
      public static WebDriver driver = null;
      
      public static void getBrowser() {
    	  driver = new ChromeDriver();
    	  driver.get("http://demowebshop.tricentis.com/");
      }
}

