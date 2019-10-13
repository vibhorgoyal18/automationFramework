package test.automation.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverInitializer {

    public WebDriver web(Browser browser) throws Exception {
        WebDriver driver = null;
        switch (browser) {
            case CHROME:
                driver = new ChromeDriver();
                break;

            case CHROME_HEADLESS:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                driver = new ChromeDriver(options);
                break;

            case EDGE:
                driver = new EdgeDriver();
                break;

            case SAFARI:
                driver = new SafariDriver();
                break;

            case FIREFOX:
                driver = new FirefoxDriver();
                break;

            default:
                throw new Exception("The driver is not implemented");
        }
        return driver;
    }
}

enum Browser {
    CHROME, CHROME_HEADLESS, FIREFOX, SAFARI, EDGE
}



