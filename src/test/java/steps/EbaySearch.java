package steps;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import base.BrowserFactory;
import base.PicoTestContainer;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.EbayHome;

public class EbaySearch extends BrowserFactory {

	EbayHome ebayHome;

	public EbaySearch(PicoTestContainer pico) {
		ebayHome = pico.getPageObjectManager().getEbayHome();
	}

	@Given("I should navigate to Ebay URL")
	public void i_should_navigate_to_ebay_url() {
		ebayHome.navigateToEbay();
	}

	@When("I will type the product and select the product catagory")
	public void i_will_type_the_product_and_select_the_product_catagory() {
		ebayHome.enterSearchText("iPhone");
		ebayHome.selectProdCatagory("Cell Phones & Accessories");
	}

//Cucumber Expression
	@When("I will type the product name as {string} and select the product catagory as {string}")
	public void i_will_type_the_product_name_as_and_select_the_product_catagory_as(String prodName,
			String prodCatagory) {
		ebayHome.enterSearchText(prodName);
		ebayHome.selectProdCatagory(prodCatagory);
	}

	@When("I will type the product name from the below data table as a map")
	public void i_will_type_the_product_name_from_the_below_data_table_as_a_map(DataTable dataTable) {
		List<Map<String, String>> rows = dataTable.asMaps();
		for (Map<String, String> row : rows) {
			String prodName = row.get("ProductName");
			String prodCat = row.get("ProductCatagory");
			ebayHome.enterSearchText(prodName);
			ebayHome.selectProdCatagory(prodCat);
		}
	}

	@When("I will click on search button")
	public void i_will_click_on_search_button() {
		ebayHome.clickOnSearchButton();
	}

	@Then("I should see the search product result")
	public void i_should_see_the_search_product_result() {
		String sResult = ebayHome.getSearchResult();
		System.out.println("Result is : " + sResult);
		sResult = sResult.replaceAll("[^0-9]", "");
		int iResult = Integer.parseInt(sResult);
		System.out.println("Number Result is : " + iResult);
	}
}
