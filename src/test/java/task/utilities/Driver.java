package task.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

public class Driver {


    private static WebDriver driver;
    public Driver(){}

    @BeforeMethod(alwaysRun = true)
    public static WebDriver getDriver(){

        String choosenBrowser = ConfigReader.getProperty("browser");
        if(driver == null){

            switch (choosenBrowser){
                case "firefox" :
                    driver= new FirefoxDriver();
                    break;
                case "safari" :
                    driver= new SafariDriver();
                    break;
                case "edge" :
                    driver = new EdgeDriver();
                    break;
                default:
                    driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }


    @AfterMethod(alwaysRun = true)
    public static void closeDriver(ITestResult result) throws IOException {

        if(result.getStatus() == ITestResult.SUCCESS) {
            // new File(System.getProperty("user.dir")+"/target");
            File img = new File(System.getProperty("user.dir")+"/target/fail.png");
            FileOutputStream screenshotStream = new FileOutputStream(img);
            screenshotStream.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            screenshotStream.close();
        }

        if (driver != null){
            driver.close();
            driver=null;
        }
    }



}
