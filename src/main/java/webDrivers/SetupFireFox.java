package webDrivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SetupFireFox {


    public static WebDriver driver1 = null;

    public static WebDriver SetupFireFox(String Platform, String URL, String Name) {


        if (Platform.equalsIgnoreCase("mac") && (Name.equalsIgnoreCase("firefox"))) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/Drivers/chromedriver");
        } else if (Platform.equalsIgnoreCase("windows") && (Name.equalsIgnoreCase("Gecko"))) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/Drivers/geckodriver.exe");
        }

        driver1 = new FirefoxDriver();
        driver1.get(URL);

        driver1.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver1.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        driver1.manage().window().maximize();

        return driver1;
    }

    @Test
    public void Amazon() {

        SetupFireFox("mac","https://amazon.com","chrome");
        driver1.get("https://amazon.com");

        driver1.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("jewelry");
        driver1.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/form/div[2]/div/input")).click();

        driver1.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/div/a[4]/span[2]")).click();

        driver1.navigate().to("https://www.youtube.com");
        driver1.navigate().to("https://www.google.com");
        driver1.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div/div[1]/div/div[1]/input")).sendKeys("Best Goal of Lionel Messi");
        driver1.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div/div[3]/center/input[1]")).click();

        driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver1.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);

    }

   /* @AfterTest
    public void quit(){
        driver1.quit();
    }*/


}
