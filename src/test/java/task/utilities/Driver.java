package task.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {


        private static WebDriver driver;
        private Driver(){}

        public static WebDriver getDriver(){


            String choosenBrowser = ConfigReader.getProperty("browser");
            // chrome, firefox, safari, edge


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


        public static void closeDriver(){

            if (driver != null){
                driver.close();
                driver=null;
            }
        }



}
