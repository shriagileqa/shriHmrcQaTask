package implementation;

import java.util.concurrent.TimeUnit;

import cucumber.api.java.After;
import setups.BasePage;
import setups.BrowserSetup;

public class Hook extends BasePage {

    BrowserSetup browsersetup = new BrowserSetup();
    private static final int WAIT_SEC = 20;


    public void initializeTest() {
        browsersetup.selectBrowser();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(WAIT_SEC, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(WAIT_SEC, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(WAIT_SEC, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    
    @After
    public void quitBrowser() {
    	driver.quit();
    }
}

