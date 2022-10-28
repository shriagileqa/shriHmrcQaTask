package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import setups.BasePage;

public class HomePage extends BasePage {

	public HomePage() {
        PageFactory.initElements(driver, this);
    }
    
  @FindBy(xpath = "//a[text()='Dresses']")
  public List<WebElement> dresstab;
  
 public boolean clickDressText() {	
	 try {
		 dresstab.get(1).click();
		 return true;
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	 return false;
 }
}

