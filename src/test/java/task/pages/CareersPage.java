package task.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import task.utilities.Driver;

public class CareersPage {

    //Locators
    public CareersPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath="(//a[@class='nav-link dropdown-toggle hide-after'])[5]")
    public WebElement companyDropdown;

    @FindBy(id="career-our-location")
    public WebElement locationsArea;

    @FindBy(id="career-find-our-calling")
    public WebElement teamsArea;

    @FindBy(xpath="//h2[contains(text(), 'Life at Insider')]")
    public WebElement lifeAtInsiderArea;



    public static void assert_text(WebElement element, Object text){
        String page_text=element.getText();
        Assert.assertEquals(page_text, text);
    }

    public void check_isDisplayed(WebElement element){
        element.isDisplayed();
    }





}










//div[@class='elementor-heading-title elementor-size-default'])[5] life
//"(//h3[@class='category-title-media'])[2]" location
// elementor-widget-container 13
//"//div[@class='elementor-heading-title elementor-size-default'])[5]"
