package webDrivers;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TakeScreenshot {

    public static void getScreenshot(WebDriver driver) {

        // Date Format Class
        DateFormat df = new SimpleDateFormat("MM.dd.yyyy-HH:mma");

        Date date = new Date();

        String name = df.format(date);

        //class variable = interface driver method parameter of file output
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);


        try {
            FileUtils.copyFile(file,new File("src/screenshot/"+name+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        driver.quit();
    }
}
