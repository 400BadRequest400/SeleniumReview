package webDrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SetupAllDriversMain {
    public static WebDriver driver = null;
    public static String Browser = "gecko";
    public  static String Name = "mac";

    public static void main(String[] args) {

        if (Browser.equalsIgnoreCase("Chrome") && (Name.equalsIgnoreCase("mac"))) {
            System.setProperty("webdriver.chrome.driver","src/main/resources/Drivers/chromedriver");
            driver = new ChromeDriver();
            driver.get("https://www.ebay.com");

        }else if (Browser.equalsIgnoreCase("gecko") && (Name.equalsIgnoreCase("mac"))){
            System.setProperty("webdriver.gecko.driver","src/main/resources/Drivers/geckodriver 2");
            driver = new FirefoxDriver();
            driver.get("https://www.ebay.com");

        }else if (Browser.equalsIgnoreCase("Safari") && (Name.equalsIgnoreCase("mac"))){
            System.setProperty("webdriver.safari.driver","src/main/resources/Drivers/geckodriver 2");
            driver = new SafariDriver();
            driver.get("https://www.ebay.com");
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(driver.getTitle());
        driver.manage().window().maximize();
        System.out.println(driver.getPageSource());












    }





}
