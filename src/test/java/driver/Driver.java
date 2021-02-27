package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private static final String RESOURCES_PATH = "C:\\Users\\User\\Downloads\\";
    private static WebDriver driver;

    private Driver(){}
    public static WebDriver getDriver() {
        if (null == driver) {
            switch (System.getProperty("browser")) {
                case "firefox": {
                    System.setProperty("webdriver.gecko.driver", RESOURCES_PATH + "geckodriver.exe");
                    driver = new FirefoxDriver();
                }
                default: {
                    System.setProperty("webdriver.chrome.driver", RESOURCES_PATH + "chromedriver.exe");
                    driver = new ChromeDriver();
                }

            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }

    }