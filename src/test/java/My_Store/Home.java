package My_Store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java .en.Then;

public class Home {


@Then("Click on Dresses$")
public void Click_on_Dresses()
{
	WebElement element=SignIn.driver.findElement(By.linkText("DRESSES"));
	Actions action= new Actions(SignIn.driver);
	action.moveToElement(element).build().perform();
}
@Then("Click on Summer Dresses$")
public void Click_Summer_Dresses()
{
	new WebDriverWait(SignIn.driver, 30).ignoring(Exception.class).until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("SUMMER")));
	SignIn.driver.findElement(By.partialLinkText("SUMMER")).click();
}
@Then("User is navigated to Summer Dresses page$")
public void Display_Summer_page()
{
//	 Assert.assertTrue(driver.findElement(By.xpath("//label[@for='selectProductSort']")).isDisplayed());
	Assert.assertTrue(SignIn.driver.getTitle().contains("Summer Dresses"));
	 System.out.println("Summer Dresses page is displayed");
	}

	}

