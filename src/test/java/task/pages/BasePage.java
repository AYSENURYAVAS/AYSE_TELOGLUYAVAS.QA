package task.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import task.utilities.Driver;
import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    Actions actions = new Actions(Driver.getDriver());

    public BasePage() {
        this.driver = Driver.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement find(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(WebElement element){
        find(element).click();
    }

    public static void wait(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void acceptCookies() {
        try {
            WebElement cookieButton = Driver.getDriver().
                    findElement(By.xpath("(//div[@class='cli-bar-btn_container']//a[contains(text(),'Accept')])"));

            if (cookieButton.isDisplayed()) {
                cookieButton.click();
                System.out.println("Çerezler kabul edildi.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Çerez butonu bulunamadı, zaten görünmüyor olabilir.");
        }
    }

    public static void assert_url(String text){
        String actualUrl= Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(text));
    }

    public static void switchToWindowByUrl(String targetUrl){
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if(Driver.getDriver().getCurrentUrl().contains(targetUrl)){
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }

    public void moveToElement(WebElement element){
        actions.moveToElement(element).perform();
    }






}
