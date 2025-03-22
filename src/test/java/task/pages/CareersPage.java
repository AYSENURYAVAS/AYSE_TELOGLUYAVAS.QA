package task.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import task.utilities.Driver;

public class CareersPage {

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

}










//div[@class='elementor-heading-title elementor-size-default'])[5] life
//"(//h3[@class='category-title-media'])[2]" location
// elementor-widget-container 13
//"//div[@class='elementor-heading-title elementor-size-default'])[5]"
