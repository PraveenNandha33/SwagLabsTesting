package stepDefinition;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageFactory.SwagLabsPages;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CheckoutStepDefinition {
	
	WebDriver driver;
	SwagLabsPages slp;
	
	@Before
	public void setup()
	{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Praveennandha\\eclipse-workspace\\SwagLabTestAutomation\\WebDrivers\\chromedriver.exe");
	driver=new ChromeDriver();
	slp=new SwagLabsPages(driver);
	
	}
	@After
	public void afterTest()
	{
	driver.quit();	
	}
	

	    @Given("^The user is  on the cart page and the product is the cart$")
	    public void the_user_is_on_the_cart_page_and_the_product_is_the_cart() throws InterruptedException{
	    	   driver.get("https://www.saucedemo.com/");
	    	   slp.getUsernameField().sendKeys("standard_user");
	           slp.getpasswordField().sendKeys("secret_sauce");
	           Thread.sleep(2000);
	           slp.getLoginButton().click();
	           slp.getProduct().click();
	           slp.getAddToCart().click();
	           slp.getShoppingCart().click();
	    }

	    

	    @When("^The user clicks on checkout$")
	    public void the_user_clicks_on_checkout()  {
	    	slp.getCheckout().click();        
	    }



	    @Then("^Checkout Page is displayed with pricing details$")
	    public void checkout_page_is_displayed_with_pricing_details() {
	    	
	         String URL="https://www.saucedemo.com/checkout-step-two.html";
	         String actualURL=driver.getCurrentUrl();
	         Assert.assertEquals(URL, actualURL);
	        
	    }

	    

	    @And("^The user enters the first name \"([^\"]*)\" second name \"([^\"]*)\" ,postal code \"([^\"]*)\" and clicks continue$")
	    public void the_user_enters_the_first_name_something_second_name_something_postal_code_something_and_clicks_continue(String firstname, String secondName, String pincode) {
	       slp.getFirstName().sendKeys(firstname);
	       slp.getLastName().sendKeys(secondName);
	       slp.getPostalCode().sendKeys(pincode);
	       slp.getContinueButton().click();
	       
	    	
	    }
	    
	    @And("^After clicking Finish ,\"([^\"]*)\"  message should  be displayed$")
	    public void after_clicking_finish_something_message_should_be_displayed(String message)  {
	        slp.getFinish().click();
	        String  actualMessage =  slp.getTitle().getText();
	        Assert.assertEquals(actualMessage, message);
	    }

}
