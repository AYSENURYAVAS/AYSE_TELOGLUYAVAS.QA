package task.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import task.pages.CareersPage;
import task.pages.HomePage;
import task.utilities.ConfigReader;
import task.utilities.Driver;
import task.utilities.Methods;


public class Case01 {


    @Test
    public void test01(){
        HomePage homePage= new HomePage();
        CareersPage careersPage=new CareersPage();

        //Visit https://useinsider.com/
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        Methods.wait(2);
        Methods.acceptCookies();

        //Check Insider home page is opened or not
        String expectedUrl= "insider";
        String actualUrl= Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        //Select the “Company” menu in the navigation bar
        homePage.companyDropdown.click();

        //Select “Careers” menu in the dropdown and verify
        homePage.careers.click();
        String expectedCareersUrl= "careers";
        String actualCareersUrl= Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualCareersUrl.contains(expectedCareersUrl));
        Methods.wait(2);

        //Check its Locations, Teams, and Life at Insider blocks are open or not
        Methods.scrollToElement(Driver.getDriver(), careersPage.teamsArea);
        Methods.wait(3);
        Assert.assertTrue(careersPage.teamsArea.isDisplayed());

        Methods.scrollToElement(Driver.getDriver(), careersPage.locationsArea);
        Methods.wait(3);
        Assert.assertTrue(careersPage.locationsArea.isDisplayed());

        Methods.scrollToElement(Driver.getDriver(), careersPage.lifeAtInsiderArea);
        Methods.wait(3);
        Assert.assertTrue(careersPage.lifeAtInsiderArea.isDisplayed());












    }





}
