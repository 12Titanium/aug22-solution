package hooks;

import com.microsoft.playwright.Page;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.WebActions;

public class Hooks {
    public DriverFactory driverFactory;
    public Page page;

    @Before
    public void launchBrowser() {
        String browserName = WebActions.getProperty("browser");
        driverFactory = new DriverFactory();
        page = driverFactory.initDriver(browserName);
    }

    @After(order = 0)
    public void setup() {
        // Close the browser is open from previous test.
        page.close();
    }

    @After(order = 1)
    public void cleanup() {
        // Test results Reporting and cleanup goes here
    }


}
