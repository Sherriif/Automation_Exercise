package Tests;

import Pages.Login_SignupPage;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.Setup;

public class RegisterUserWithExistingEmail extends Setup {
    @Test
    public void TestRegisterWithExistingEmail(){
        test = extent.createTest("Test Register With Existing Email");
        test.info("test case started");
        try {
            Assert.assertTrue(homePage.HomePageVisibility());
            test.log(Status.PASS, "Home Page is visible");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Home Page is Not Visible");
        }
        Login_SignupPage loginSignupPage = homePage.clickOnLogin();
        try {
            Assert.assertEquals(loginSignupPage.NewUserSignupVisibility(), "New User Signup!");
            test.log(Status.PASS, "Login_Signup page is verified");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Login_Signup Page Is Not Visible");
        }
        loginSignupPage.SetName("sherif");
        loginSignupPage.SetEmailAddress("sherif8@gmail.com");
        loginSignupPage.ClickSignup();
        try {
            Assert.assertEquals(loginSignupPage.VerifyErrorMessageIsVisible(), "Email Address already exist!");
            test.log(Status.PASS, "Error Message Is Visible");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Error Message is NOt Visible");
        }
    }
}
