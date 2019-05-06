package webDrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class SetupChrome {

    public static WebDriver driver = null;

    public static WebDriver Setupdriver(String platform, String URL, String Name){

        if (platform.equalsIgnoreCase("mac") && Name.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","src/main/resources/Drivers/chromedriver");
        }else if (platform.equalsIgnoreCase("windows") && Name.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","src/main/resources/Drivers/chromedriver.exe");
        }
        driver = new ChromeDriver();
        driver.get(URL);

        return  driver;

    }

    public static void main(String[] args) {

        //create driver object for chromedriver
        //we will strictly implement methods of web driver
        //selenium set a property // webdriver.chrome.driver
        Setupdriver("mac","https://google.com","chrome");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
        //driver.close();

    }








}
