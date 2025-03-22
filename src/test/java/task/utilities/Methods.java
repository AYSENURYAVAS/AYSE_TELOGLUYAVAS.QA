package task.utilities;

import org.openqa.selenium.*;
import org.testng.Assert;
import task.pages.QAPage;

import java.util.List;

public class Methods {

    //Reusable methods
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

    //Case02
    public static void checkAllQaPositions(){

        QAPage qaPage=new QAPage();
        int page = 1;

        while (true){
            scrollToElement(Driver.getDriver(),qaPage.departmentDropdown);

            for (WebElement job : qaPage.jobBoxes) {
                wait(5);
                String jobTitle = qaPage.department.getText().trim();
                String jobLocation = qaPage.location.getText().trim();
                //String jobLink = job.findElement(By.xpath(".//a")).getAttribute("href");
                System.out.println("Job Title: " + jobTitle);
                System.out.println("Location: " + jobLocation);
                //System.out.println("Apply Link: " + jobLink);
                System.out.println("-----------------------------");
                Assert.assertTrue(jobTitle.contains("Quality Assurance"), "Department mismatch: " + jobTitle);
                Assert.assertTrue(jobLocation.contains("Istanbul, Turkiye"), "Location mismatch: " + jobLocation);
            }

            if(qaPage.nextButton.getDomAttribute("disabled") == null){
                break;
            } else {
                qaPage.nextButton.click();
                Methods.wait(2);
                page++;
            }
            }
        }





}
















// for (int i = 0; i < qaPage.departments.size(); i++) {
//    String title = qaPage.departments.get(i).getText();
//   String location = qaPage.locations.get(i).getText();

//    Assert.assertEquals("Quality Assurance", title);
//   Assert.assertEquals("Istanbul, Turkiye", location);

//    System.out.println("Departman: " + title + ", Konum: " + location);
// }
//