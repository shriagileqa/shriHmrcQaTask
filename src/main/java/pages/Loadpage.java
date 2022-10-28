package pages;

import implementation.Hook;
import setups.BasePage;
import setups.LoadProp;

public class Loadpage extends BasePage {

    public static void homePage() {
    	Hook h = new Hook();
    	h.initializeTest();
        driver.get(LoadProp.getproperty("url"));
    }
  
}
