package My_Store;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignIn {
	public static WebDriver driver;
	public Properties prop;
	
	
@After
public void teardown() {
	if(driver!=null)
		Closebrowser();
}

@Given("^Open the browser\"([^\"]*)\"$")
public void open_the_browser(String browser) throws Throwable {
	if(browser.equalsIgnoreCase("chrome"))
	{
		 System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//driver.navigate().to("http://automationpractice.com/");
		
	}
	else if (browser.equalsIgnoreCase("firefox"))
	{
		System.setProperty("webdriver.Gecko.driver", "C:\\Work\\geckodriver.exe");
		driver= new FirefoxDriver();
	}
		 
			//driver.navigate().to("http://automationpractice.com/");  */
		 
		 
		
}
@Given("Launch the AUT$")

public void LaunchApplication()
{
	driver.navigate().to("http://automationpractice.com/");
}
@When("Click on SignIn button$")
public void SignInbutton()
{
	//log= "//a[@class='login']";
	//find(:xpath,log)
	driver.findElement(By.xpath("//a[@class='login']")).click();
}


@Then("Close the browser$")
public void Closebrowser()
{
	driver.close();
	driver.quit();
	driver = null;
	
}

@When("Enter email address\"([^\"]*)\"$")
public void enter_email_address(String email) {
	driver.findElement(By.cssSelector("input[id='email_create']")).sendKeys(email);
}

@When("Click on Create Account button$")
public void click_create_account_button() throws InterruptedException {
	Thread.sleep(2000);
//	driver.findElement(By.xpath("//*[@id=\"create-account_form\"]/div/div[3]")).click();
	driver.findElement(By.xpath("//*[@id=\"create-account_form\"]/div/div[3]")).submit();
}

@Then("^User is navigated to User details page$")
public void verify_landing_page() {
	new WebDriverWait(driver, 30).ignoring(Exception.class).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='id_gender1']")));
	 Assert.assertTrue(driver.findElement(By.xpath("//input[@id='id_gender1']")).isDisplayed());
	 System.out.println("Create Account Page is displayed");
}

@When("User is able to fill all mandatory fields$")
public void Filling_Mandatory_Fields()
{
	driver.findElement(By.xpath("//input[@data-validate='isName']")).sendKeys("Gina");
    driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("brown");
    driver.findElement(By.xpath("//input[@type='password']")).sendKeys("abcdef");
    driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Gina");	  
    driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("Unit 5, Thomas street");
    driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Miami");
    Select State = new Select(driver.findElement(By.cssSelector("select[id='id_state']")));
    State.selectByVisibleText("Florida");
    driver.findElement(By.cssSelector("input[id='postcode']")).sendKeys("33101");
    Select Country = new Select(driver.findElement(By.cssSelector("select[id='id_country']")));
    Country.selectByVisibleText("United States");
    driver.findElement(By.xpath("//input[@name='phone_mobile']")).sendKeys("0432343222");
    
}
@When("Click on Register button$")
public void Click_Register() throws InterruptedException {
    driver.findElement(By.xpath("//button[@id='submitAccount']//span")).click();
Thread.sleep(2000);
}



@Then("User created account successfully$")
public void Created_Account()
{
//	driver.findElement(By.id("my-account")).isDisplayed();
	String pagename = driver.getTitle();
	Assert.assertTrue(pagename.equals("My account - My Store"));
	System.out.println("Account got created Successfully");
}



@Then("^Appropriate error message is displayed$")
public void verify_error_message() {
	new WebDriverWait(driver, 30).ignoring(Exception.class).until(ExpectedConditions.visibilityOfElementLocated(By.id("create_account_error")));
	String errorMessage = driver.findElement(By.id("create_account_error")).getText();
	Assert.assertTrue(errorMessage.contains("Invalid email address."));
	System.out.println("Error message is validated");
	
}

}
