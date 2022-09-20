package stepDefinition;

//import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PageFactory.SwagLabsPages;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartStepDefinition {
	
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
	String productName;	
    @Given("^The user is in the home page$")
    public void the_user_is_in_the_home_page() throws InterruptedException  {
    	   driver.get("https://www.saucedemo.com/");
    	   slp.getUsernameField().sendKeys("standard_user");
           slp.getpasswordField().sendKeys("secret_sauce");
           Thread.sleep(2000);
           slp.getLoginButton().click();
        
    }

    

    @When("^The user clicks on the product$")
    public void the_user_clicks_on_the_product() throws Throwable {
        //clicking product
    	slp.getProduct().click();
    	
        
    }

    @When("^The user clicks on Add to cart on first product$")
    public void the_user_clicks_on_add_to_cart_on_first_product()  {
    	
    	slp.getAddToCart().click();//clicking add to cart
    	
        
    }

    

    @Then("^The product should be added to cart$")
    public void the_product_should_be_added_to_cart() throws Throwable {
    	
    	slp.getShoppingCart().click(); 
    	
    	String cartProductName=slp.getItemName().getText();
    	Assert.assertEquals(productName, cartProductName);
        
    }

    @Then("^The cart count should be increased to \"([^\"]*)\"$")
    public void the_cart_count_should_be_increased_to_something(String actualCount) {
    	
    	String count=slp.getBadge().getText();
    	Assert.assertEquals(actualCount, count);
        
    }

    

    @And("^The user clicks on the add to cart button$")
    public void the_user_clicks_on_the_add_to_cart_button() {
    	
    	productName=slp.getProductName().getText();
    	
    	slp.getAddToCart().click();
        
    }

    @And("^The user clicks on Add to cart on the Second product$")
    public void the_user_clicks_on_add_to_cart_on_the_second_product()  {
    	
    	slp.getSecAddtoCart().click();
        
    }

    

}