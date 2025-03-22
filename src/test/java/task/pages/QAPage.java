package task.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import task.utilities.Driver;

import java.util.List;

public class QAPage {

    public QAPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (linkText="See all QA jobs")
    public WebElement seeAllButton;
    //(//a[@class='btn-outline-secondary'])
    //btn-outline-secondary

    @FindBy(xpath="(//span[@class='select2-selection__arrow'])[2]")
    public WebElement departmentDropdown;
    //select2-selection__arrow
    //id="select2-filter-by-department-container"
    @FindBy(xpath="(//span[@class='select2-selection__arrow'])[1]")
    public WebElement locationDropdown;
    //id="select2-filter-by-location-container"
    @FindBy(xpath="(//li[@class='select2-results__option'])[1]")
    public WebElement istanbulArea;

    @FindBy(id="jobs-list")
    public List<WebElement> jobList;

    @FindBy(xpath = "//div[contains(@class, 'position-list-item-wrapper')]")
    public List<WebElement> jobBoxes;

    @FindBy(xpath=".//span[contains(@class, 'position-department')]")
    public WebElement department;


    @FindBy(xpath=".//div[contains(@class, 'position-location')]")
    public WebElement location;

    @FindBy(id="resultCounter")
    public WebElement resultCounter;

    @FindBy(xpath="(//i[@class='icon-arrow-right'])")
    public WebElement nextButton;

    @FindBy(xpath="//a[contains(@class, 'btn-navy') and contains(text(), 'View Role')]")
    public WebElement viewRole;

}
