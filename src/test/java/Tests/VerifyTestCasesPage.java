package Tests;

import Pages.TestCasesPage;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.Setup;

public class VerifyTestCasesPage extends Setup {
    @Test
    public void TestCasesPageIsVisible(){
        test = extent.createTest("validate Test Cases Page");
        test.info("test case started");
        try {
            Assert.assertTrue(homePage.HomePageVisibility());
            test.log(Status.PASS, "Home Page is visible");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Home Page is Not Visible");
        }
        TestCasesPage testCasesPage = homePage.ClickOnTestCasesBtn();
        try {
            Assert.assertEquals(testCasesPage.SuccessfulNavigationForTestCasesPage(), "TEST CASES");
            test.log(Status.PASS, "Successful Navigation To Test Cases Page");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Navigation To Test Cases Page is Field");
        }

    }
}
