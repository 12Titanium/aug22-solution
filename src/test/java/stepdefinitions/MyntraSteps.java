package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.TShirtsPage;

public class MyntraSteps {
    HomePage homePage = new HomePage(DriverFactory.getPage());
    TShirtsPage tShirtsPage = new TShirtsPage(DriverFactory.getPage());

    @Given("I am on the Myntra homepage")
    public void i_am_on_the_myntra_homepage() {
        homePage.navigateToHomePage();
    }

    @When("I navigate to the Men T-shirts section")
    public void i_navigate_to_the_men_tshirts_section() {
        homePage.navigateToMenTShirts();
    }

    @And("I filter by brand {string}")
    public void i_filter_by_brand(String brand) {
        tShirtsPage.filterByBrand(brand);
    }

    @And("I filter for discounted T-shirts")
    public void i_filter_for_discounted_discounted_tshirts(){
        tShirtsPage.filterForDiscountedTShirts();
    }

    @Then("I extract the discounted T-shirts data and print them sorted by discount")
    public void i_extract_the_discounted_tshirts_data_and_print_them_sorted_by_discount() {
        tShirtsPage.extractTShirtDataAndPrintSortedByDiscount();
    }
}
