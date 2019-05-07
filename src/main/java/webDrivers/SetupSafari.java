package webDrivers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;


public class SetupSafari {


    public static void main(String[] args) {

        System.setProperty("webdriver.safari.driver","src/main/resources/Drivers/SafariDriver (1).safariextz");

        WebDriver driver2 = new SafariDriver();

        driver2.get("https://www.google.com");

        System.out.println(driver2.getTitle());
        driver2.manage().window().maximize();

    }

}
