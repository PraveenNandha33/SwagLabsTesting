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


public class LoginPageStepDefinition {
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
	
	
	    
	    @Given("^The user is on the login page$")
	    public void the_user_is_on_the_login_page()  {
	        driver.get("https://www.saucedemo.com/");
	    }

	    @When("^The user enters the valid username (.+) and password (.+) and clicks login$")
	    public void the_user_enters_the_valid_username_and_password(String username, String password) throws InterruptedException  {
	    	slp.getUsernameField().sendKeys(username);
	           slp.getpasswordField().sendKeys(password);
	           Thread.sleep(2000);
	           slp.getLoginButton().click();    
	    }

	    @Then("^The Home should be displayed$")
	    public void the_home_should_be_displayed() {
	    	String currentURL=driver.getCurrentUrl();
	    	Assert.assertEquals(currentURL,"https://www.saucedemo.com/inventory.html");
	        
	    }
        
	    @When("^The user enters the valid username \"([^\"]*)\" and password \"([^\"]*)\"$")
	    public void the_user_enters_the_valid_username_something_and_password_something(String username, String password) throws InterruptedException  {
	    	   slp.getUsernameField().sendKeys(username);
	           slp.getpasswordField().sendKeys(password);
	           Thread.sleep(2000);
	           slp.getLoginButton().click(); 
          
	    }

	    @Then("^The error message should be displayed$")
	    public void the_error_message_should_be_displayed() {
	    	String expectedError="Epic sadface: Sorry, this user has been locked out.";
	    	String actualError=driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[1]/div/form/div[3]")).getText();
	    	Assert.assertEquals(expectedError,actualError);     
	    }
	    @Given("^The user is logged in with username \"([^\"]*)\"  and password \"([^\"]*)\" and in the home page$")
	    public void the_user_is_logged_in_with_username_something_and_password_something_and_in_the_home_page(String username, String password) throws InterruptedException  {
	    	driver.get("https://www.saucedemo.com/");
	    	 slp.getUsernameField().sendKeys(username);
	           slp.getpasswordField().sendKeys(password);
	           Thread.sleep(2000);
	           slp.getLoginButton().click(); 
           
	    	
	    }

	    @When("^The user clicks on the hamburger button$")
	    public void the_user_clicks_on_the_hamburger_button() throws InterruptedException {
	    	Thread.sleep(2000);
	     slp.getMenu().click();
	    }
     
	    @And("^The user Clicks logout$")
	    public void the_user_clicks_logout() throws InterruptedException  {
	    	Thread.sleep(2000);
	    	slp.getLogout().click();   	
	       
	    }
	    
	    @Then("^The login page should be displayed$")
	    public void the_login_page_should_be_displayed() {
	    	String currentURL=driver.getCurrentUrl();
	    	String actualURL="https://www.saucedemo.com/";
	    	Assert.assertEquals(currentURL, actualURL);
	    	
	        
	    }

	    

}
