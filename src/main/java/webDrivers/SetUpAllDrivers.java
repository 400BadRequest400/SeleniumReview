package webDrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class SetUpAllDrivers {

    public static WebDriver driver = null;

    public static WebDriver SetupAllDriver(String Platform, String Url, String Browser){


        if (Platform.equalsIgnoreCase("mac") && (Browser.equalsIgnoreCase("chrome"))) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver");
            driver = new ChromeDriver();
            System.out.println(driver.getTitle());

        }else if (Platform.equalsIgnoreCase("mac") && (Browser.equalsIgnoreCase("Firefox"))){
            System.setProperty("webdriver.gecko.driver","src/main/resources/Drivers/geckodriver 2");
            driver = new FirefoxDriver();
            System.out.println(driver.getTitle());

        }else if (Platform.equalsIgnoreCase("mac") && (Browser.equalsIgnoreCase("Safari"))){
            System.setProperty("webdriver.safari.driver","src/main/resources/Drivers/safaridriver 2");
            driver = new SafariDriver();
            System.out.println(driver.getTitle());
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.get(Url);
        return driver;
    }

    @Test
    public void DriversTest(){
        SetupAllDriver("mac","https://www.amazon.com","chrome");

        driver.getCurrentUrl();
        driver.manage().deleteAllCookies();
    }

    @Test
    public void quit(){
        driver.quit();
    }
}
