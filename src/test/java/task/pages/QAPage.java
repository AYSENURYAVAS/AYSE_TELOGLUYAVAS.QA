package task.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import task.utilities.Driver;

import java.util.List;


public class QAPage extends BasePage {
    public QAPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "See all QA jobs")
    public WebElement seeAllButton;

    @FindBy(xpath = "(//span[@class='select2-selection__arrow'])[2]")
    public WebElement departmentDropdown;

    @FindBy(xpath = "(//span[@class='select2-selection__arrow'])[1]")
    public WebElement locationDropdown;

    @FindBy(xpath = "(//li[@class='select2-results__option'])[1]")
    public WebElement istanbulArea;

    @FindBy(id = "jobs-list")
    public List<WebElement> jobList;

    @FindBy(xpath = "//div[contains(@class, 'position-list-item-wrapper')]")
    public List<WebElement> jobBoxes;

    // Department and location inside each jobBox
    @FindBy(xpath = ".//span[contains(@class, 'position-department')]")
    public List<WebElement> department;

    @FindBy(xpath = ".//div[contains(@class, 'position-location')]")
    public List<WebElement> location;

    @FindBy(id = "resultCounter")
    public WebElement resultCounter;

    @FindBy(xpath = "(//i[@class='icon-arrow-right'])")
    public WebElement nextButton;

    @FindBy(xpath = "(//a[contains(@class, 'btn-navy') and contains(text(), 'View Role')])[1]")
    public WebElement viewRole;

    public void checkAllQaPositions() {
        int page = 1;

        while (true) {
            scrollToElement(Driver.getDriver(), departmentDropdown);

            for (int i = 0; i < jobBoxes.size(); i++) {
                System.out.println("job: " + jobBoxes.get(i));
                wait(3);
                String jobTitle = department.get(i).getText().trim();
                String jobLocation = location.get(i).getText().trim();
                System.out.println("Job Title: " + jobTitle);
                System.out.println("Location: " + jobLocation);
                System.out.println("-----------------------------");
                Assert.assertTrue(jobTitle.contains("Quality Assurance"), "Department mismatch: " + jobTitle);
                Assert.assertTrue(jobLocation.contains("Istanbul, Turkiye"), "Location mismatch: " + jobLocation);
            }

            if (nextButton.getDomAttribute("disabled") == null) {
                break;
            } else {
                nextButton.click();
                page++;
            }
        }
    }

    // Utility methods
    public static void scrollToElement(org.openqa.selenium.WebDriver driver, WebElement element) {
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
