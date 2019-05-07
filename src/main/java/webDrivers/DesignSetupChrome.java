package webDrivers;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class DesignSetupChrome {

    public static WebDriver driver = null;
    public static TakeScreenshot screenshot = null;

    public static WebDriver Setupdriver(String platform, String URL, String Name){

        if (platform.equalsIgnoreCase("mac") && Name.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","src/main/resources/Drivers/chromedriver");
        }else if (platform.equalsIgnoreCase("windows") && Name.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","src/main/resources/Drivers/chromedriver.exe");
        }
        driver = new ChromeDriver();
        driver.get(URL);

        screenshot = new TakeScreenshot();

        return  driver;
    }

    @AfterTest
    public void quit(){
        driver.quit();
    }



    @Test
    public void ebayBook (){
        Setupdriver("mac","https://ebay.com","chrome");

        System.out.println(driver.getPageSource());


        driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("Java Books");
        //screenshot.getScreenshot(driver);


        driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).click();
        //screenshot.getScreenshot(driver);


        driver.findElement(By.xpath("//*[@id=\"srp-river-results-listing1\"]/div/div[1]/div/a/div/img")).click();
        driver.findElement(By.xpath("//*[@id=\"qtyTextBox\"]")).clear();
        //screenshot.getScreenshot(driver);

        driver.findElement(By.xpath("//*[@id=\"qtyTextBox\"]")).sendKeys("2");
        driver.findElement(By.xpath("//*[@id=\"qtyTextBox\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"atcRedesignId_btn\"]")).click();

        WebElement text = driver.findElement(By.linkText("text"));

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.navigate().back();
        driver.navigate().to("https://yahoo.com");
        //screenshot.getScreenshot(driver);


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //driver.quit();
        //driver.close();
    }

}
