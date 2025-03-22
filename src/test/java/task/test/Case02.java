package task.test;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import task.pages.QAPage;
import task.utilities.ConfigReader;
import task.utilities.Driver;
import task.utilities.Methods;

public class Case02 {


   @Test
    public void test02(){

       QAPage qaPage= new QAPage();

       //Go to https://useinsider.com/careers/quality-assurance/
       Driver.getDriver().get(ConfigReader.getProperty("careersUrl"));
       Methods.acceptCookies();
       Methods.wait(2);

       //Click “See all QA jobs”
       qaPage.seeAllButton.click();

       //Filter jobs by Location: “Istanbul, Turkey”, and Department: “Quality Assurance”
       qaPage.departmentDropdown.click();
       Methods.wait(20);
       qaPage.locationDropdown.click();
       qaPage.istanbulArea.click();
       Methods.wait(3);

       //Check the presence of the job list
       Methods.scrollToElement(Driver.getDriver(), qaPage.resultCounter);
      // Assert.assertTrue(qaPage.jobList.isDisplayed());

       //Check that all jobs’ Position contains “Quality Assurance”, Department contains
       //“Quality Assurance”, and Location contains “Istanbul, Turkey”
       Methods.checkAllQaPositions();


       //Click the “View Role” button and check that this action redirects us to the Lever
       //Application form page
       qaPage.viewRole.click();
       Methods.switchToWindowByUrl("lever");
       String expectedNewUrl= "lever";
       String actualNewUrl= Driver.getDriver().getCurrentUrl();
       Assert.assertTrue(actualNewUrl.contains(expectedNewUrl));



    }






}
