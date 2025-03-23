package task.test;

import org.testng.annotations.Test;
import task.pages.BasePage;
import task.pages.QAPage;
import task.utilities.ConfigReader;
import task.utilities.Driver;

public class Case02 {


   @Test(priority = 2)
    public void test02(){

       QAPage qaPage= new QAPage();
       BasePage basePage=new BasePage();

       //Go to https://useinsider.com/careers/quality-assurance/
       Driver.getDriver().get(ConfigReader.getProperty("careersUrl"));
       basePage.acceptCookies();

       //Click “See all QA jobs”
       basePage.click(qaPage.seeAllButton);

       //Filter jobs by Location: “Istanbul, Turkey”, and Department: “Quality Assurance”
       basePage.wait(10);
      //basePage.click(qaPage.departmentDropdown);
       basePage.click(qaPage.locationDropdown);
       basePage.click(qaPage.istanbulArea);

       //Check the presence of the job list
       basePage.scrollToElement(Driver.getDriver(), qaPage.resultCounter);
      // Assert.assertTrue(qaPage.jobList.isDisplayed());

       //Check that all jobs’ Position contains “Quality Assurance”, Department contains
       //“Quality Assurance”, and Location contains “Istanbul, Turkey”
       qaPage.checkAllQaPositions();

       //Click the “View Role” button and check that this action redirects us to the Lever
       //Application form page
       basePage.moveToElement(qaPage.viewRole);
       basePage.click(qaPage.viewRole);
       basePage.switchToWindowByUrl("lever");
       basePage.assert_url("lever");


    }






}
