package webDrivers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;


public class SetupSafari {


    public static void main(String[] args) {

        WebDriver driver2 = new SafariDriver();

        driver2.get("https://www.google.com");

        System.out.println(driver2.getTitle());
        driver2.manage().window().maximize();

    }

}
