package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import setups.BasePage;

public class AddtoCart extends BasePage {

	JavascriptExecutor js;
	public AddtoCart() {
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }
    
  @FindBy(xpath = "//*[@class='right-block']//span[@itemprop='price']")
  public List<WebElement> items;
  
  @FindBy(xpath = "//*[@class='button-container']//span[text()='Add to cart']")
  public List<WebElement> carticon;
  
  public boolean findHighestPriceItemAndAddToCart() {
	  float high;
	  List<Float> list = new ArrayList<Float>(); 
	  if(items.size()>0) {
		  for(WebElement ele : items) {
			  list.add(Float.parseFloat(ele.getText().substring(1)));
		  }
		  System.out.println("Total items list price-"+list);
		  high = Collections.max(list);
		  int count = 0;
		  for(WebElement ele : items) {
			  count++;
			  try {
				  if(ele.getText().contains(String.valueOf(high))) {
					  js.executeScript("arguments[0].scrollIntoView(true);", ele);
					  Actions action = new Actions(driver);
					  action.moveToElement(ele).perform();
					  carticon.get(count-1).click();
					  WebDriverWait wait = new WebDriverWait(driver, 30);
					  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='layer_cart_product_price']")));
					  WebElement itemadded = driver.findElement(By.xpath("//*[@id='layer_cart_product_price']"));
					  Float actualitem = Float.parseFloat(itemadded.getText().substring(1));
					  if(high==actualitem) {
						  System.out.println("Highest price $"+high+ " added to the cart");
						  return true;
					  }
				  }
			  }catch(Exception e) {
				  e.printStackTrace();
			  }
			  
		  }
		  return true;
	  }else {
		  return false;
	  }
  }

}
