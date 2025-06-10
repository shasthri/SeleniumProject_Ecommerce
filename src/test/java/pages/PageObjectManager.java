package pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

private WebDriver driver;
private AmazonHome amazonHome;
private EbayHome ebayHome;

	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public EbayHome getEbayHome() {
		if(ebayHome == null)
		{
			ebayHome = new EbayHome(driver);
		}else {
			return ebayHome;
		}
		return ebayHome;
	}
	
	public AmazonHome getAmazonHome() {
		if(amazonHome == null)
		{
			amazonHome = new AmazonHome(driver);
		}else {
			return amazonHome;
		}
		return amazonHome;
	}
}

	