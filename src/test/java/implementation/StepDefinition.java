package implementation;

import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.AddtoCart;
import pages.HomePage;
import pages.Loadpage;

public class StepDefinition {
	
	@Given("^I am on the home page$")
    public void iAmOnTheHomePage() {
        Loadpage.homePage();
    }
	
	@When("^Clicking the dress link text$")
	public void clickTheDressLinkText() {
		HomePage obj = new HomePage();
		Assert.assertTrue(obj.clickDressText(),"Dresses link unlicked for some resons");
	}
	
	@And("^Add the highest rate item to the cart$")
	public void addTheHighestRateItemToCart() {
		AddtoCart obj = new AddtoCart();
		Assert.assertTrue(obj.findHighestPriceItemAndAddToCart(),"Some reasons items not added properly");
	}
}

