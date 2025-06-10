package steps;

import java.util.List;
import java.util.Map;

import base.PicoTestContainer;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonHome;

public class AmazonSearchSD {

	AmazonHome amazonHome;

	public AmazonSearchSD(PicoTestContainer pico) {
		amazonHome = pico.getPageObjectManager().getAmazonHome();
	}

	@Given("User should navigate to Amazon")
	public void user_should_navigate_to_amazon() {
		amazonHome.mNaviagteToURL();
	}

	@When("User search with multiple products in Amazon called")
	public void user_search_with_multiple_products_called(DataTable dataTable) {
		List<Map<String, String>> searchs = dataTable.asMaps();
		for (Map<String, String> search : searchs) {
			amazonHome.mEnterProductName(search.get("ProdName"));
			amazonHome.mSelectCategory(search.get("ProdCat"));
			amazonHome.mClickSearchButton();
		}
	}

	@Then("Validate the Amazon search result")
	public void validate_the_search_result() {
		String sResult = amazonHome.mGetSearchResult();
		System.out.println("Result is : " + sResult);
	}

}
