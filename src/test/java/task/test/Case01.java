package task.test;

import org.testng.annotations.Test;
import task.pages.BasePage;
import task.pages.CareersPage;
import task.pages.HomePage;
import task.utilities.ConfigReader;
import task.utilities.Driver;


public class Case01  {


    @Test(priority = 1)
    public void test01(){

        HomePage homePage=new HomePage();
        BasePage basePage=new BasePage();
        CareersPage careersPage=new CareersPage();
        Driver driver = new Driver();

        //Visit https://useinsider.com/
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        BasePage.acceptCookies();

        //Check Insider home page is opened or not
        basePage.assert_url("insider");

        //Select the “Company” menu in the navigation bar
        basePage.click(homePage.companyDropdown);

        //Select “Careers” menu in the dropdown and verify
        basePage.click(homePage.careers);
        basePage.assert_url("careers");

        //Check its Locations, Teams, and Life at Insider blocks are open or not
        BasePage.scrollToElement(Driver.getDriver(), careersPage.teamsArea);
        careersPage.check_isDisplayed(careersPage.teamsArea);
        BasePage.scrollToElement(Driver.getDriver(), careersPage.locationsArea);
        careersPage.check_isDisplayed(careersPage.locationsArea);
        BasePage.scrollToElement(Driver.getDriver(), careersPage.lifeAtInsiderArea);
        careersPage.check_isDisplayed(careersPage.lifeAtInsiderArea);












    }





}
