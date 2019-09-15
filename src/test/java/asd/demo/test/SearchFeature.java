/*
 * Test the Login function using selenium and cucumber acceptance testing 
 */
package asd.demo.test;

/**
 *
 * @author George
 */
import org.openqa.selenium.By;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchFeature {

    WebDriver driver;

   @Given("^I am on the home page$")
    public void i_am_on_the_home_page() throws Throwable {
    }

    @When("^I fill in \"([^\"]*)\" with \"([^\"]*)\"$")
    public void i_fill_in_with(String arg1, String arg2) throws Throwable {
        
    }

    @When("^I select the \"([^\"]*)\" radio button$")
    public void i_select_the_radio_button(String arg1) throws Throwable {
    
    }

    @Then("^I should see items with category \"([^\"]*)\"$")
    public void i_should_see_items_with_category(String arg1) throws Throwable {
       
    }
}
