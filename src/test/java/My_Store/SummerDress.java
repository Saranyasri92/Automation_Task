package My_Store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import cucumber.api.java.en.When;

public class SummerDress {


@When("Validate product grid sort$")
public void Sort_by_Ascending() throws InterruptedException
{
Select sort = new Select(SignIn.driver.findElement(By.id("selectProductSort")));
sort.selectByValue("name:asc");
Thread.sleep(3000);
ArrayList<String> obtained = new ArrayList<>();
List<WebElement> unsortedItems = SignIn.driver.findElements(By.xpath("//ul[@class=\"product_list grid row\"]//li[contains(@class,'ajax')]"));
for(WebElement i:unsortedItems) {
	obtained.add(i.getText());
}

ArrayList<String> sorted = new ArrayList<>();
for(String i:obtained) {
	sorted.add(i);
}

Collections.sort(sorted);
Assert.assertTrue(sorted.equals(obtained));
System.out.println("Product grid is sucessfully sorted");
}

}



