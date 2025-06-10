package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory 
{
	public int iBrowser = 1;
	public WebDriver driver;
	
	public WebDriver launchBrowser() {
		
		if (driver == null) {
			switch (iBrowser) {
			case 1:
				System.out.println("User option is " + iBrowser + ",So invoking chrome browser");
				driver = new ChromeDriver();
				break;
				
			case 2:
				System.out.println("User option is " + iBrowser + ",So invoking edge browser");
				driver = new EdgeDriver();
				break;
				
			case 3:
				System.out.println("User option is " + iBrowser + ",So invoking firefox browser");
				driver = new FirefoxDriver();
				break;
				
			default:
				System.out.println("User option is wrong " + iBrowser + ",So invoking the default chrome browser");
				driver = new ChromeDriver();
				break;
			}
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}
}
