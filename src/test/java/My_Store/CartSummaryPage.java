package My_Store;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class CartSummaryPage {
	//public static WebDriver driver;
	//public Properties prop;
	public static String namea;
	public static String colorb;
	public static String quanc;
	public static String namex;
	public static String colory;
	public static String quanz;
	
@Then("Click the product and change it to blue color$")
public void Click_Product_changeColor()
{
	
	SignIn.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	JavascriptExecutor js = (JavascriptExecutor) SignIn.driver;
	js.executeScript("window.scrollBy(0,1000)");
	 SignIn.driver.findElement(By.linkText("Printed Summer Dress")).click();
	 System.out.println("Selected Printed Summer Dress");
	 SignIn.driver.findElement(By.cssSelector("a[id='color_14']")).click();
	 System.out.println("dress color changed to blue");
	 namea= SignIn.driver.findElement(By.cssSelector("h1[itemprop='name']")).getText();
	     colorb= SignIn.driver.findElement(By.id("color_14")).getCssValue("color");
	    quanc= SignIn.driver.findElement(By.id("quantity_wanted")).getAttribute("value");
	    
}


@Then("Validate Product name,Quantity and color in the cart summary$")
public void Validate_Cart_Summary()
{
	SignIn.driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
	System.out.println("Product is successfully added to the cart");
	System.out.println("Proceed to checkout");
	 SignIn.driver.findElement(By.partialLinkText("Proceed to")).click();
	 System.out.println("Product is displayed in Cart Summary page");
	  namex= SignIn.driver.findElement(By.partialLinkText("Printed Summer")).getText();
	  colory=SignIn.driver.findElement(By.partialLinkText("Color")).getText();
	   quanz= SignIn.driver.findElement(By.cssSelector("input[name='quantity_5_20_0_0']")).getAttribute("value");
	   
	    
	    Assert.assertTrue(namea.equals(namex) && quanc.equals(quanz) && colory.contains("Blue"));
	    System.out.println("Name, Product and Color ane Matching to the Cart Summary Page");
}
	    
	  
	    	



}
