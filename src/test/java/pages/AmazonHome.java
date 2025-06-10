package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import util.PropertyReader;

public class AmazonHome {
	
	String sURL = PropertyReader.readDataFromPropertyFile("environment", "amazonURL");
	
	private WebDriver driver;
	private By productSearchBox = By.xpath("//input[@id = 'twotabsearchtextbox']"); //Search Box
	private By productCategory 	= By.xpath("//select[@id = 'searchDropdownBox']"); //Category selection
	private By searchButton		= By.xpath("//input[@id = 'nav-search-submit-button']"); //search button
	
	//SearchResults
	private By searchResult 	= By.xpath("(//span[@data-component-type='s-result-info-bar']//h2/span)[1]");
	
	public AmazonHome(WebDriver driver) {
		this.driver = driver;		
	}
	
	public void mNaviagteToURL() {
		driver.navigate().to(sURL);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void mEnterProductName(String sProductName) {
		WebElement wProductName = driver.findElement(productSearchBox);
		wProductName.sendKeys(sProductName);
	}
	
	public void mSelectCategory(String sProductCategory) {
		WebElement wCategory = driver.findElement(productCategory);
		Select oSelect = new Select(wCategory);
		oSelect.selectByVisibleText(sProductCategory);
	}
	
	public void mClickSearchButton() {
		WebElement wSearchButton = driver.findElement(searchButton);
		wSearchButton.click();
	}
	
	public String mGetSearchResult() {
		WebElement wSearchResult = driver.findElement(searchResult);
		String sResult = wSearchResult.getText();
		return sResult;
	}
}
