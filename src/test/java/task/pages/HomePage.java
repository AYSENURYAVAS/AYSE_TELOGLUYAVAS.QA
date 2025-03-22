package task.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import task.utilities.Driver;

public class HomePage {


    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="(//a[@class='nav-link dropdown-toggle hide-after'])[5]")
    public WebElement companyDropdown;

   // @FindBy(xpath="(//div[@class='new-menu-dropdown-layout-6-mid-container'])")
    @FindBy(xpath="(//div[@class='new-menu-dropdown-layout-6-mid-container']//a[contains(text(),'Careers')])")
    public WebElement careers;




}
