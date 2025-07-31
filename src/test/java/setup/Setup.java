package setup;

import Pages.HomePage;
import Pages.Login_SignupPage;
import Pages.TestCasesPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class Setup {
    protected WebDriver driver;
    protected HomePage homePage;
    protected static ExtentReports extent;
    protected static ExtentSparkReporter sparkReporter;
    protected ExtentTest test;

    @BeforeSuite
    public void setUpExtentReport() {
        extent = new ExtentReports();
        sparkReporter = new ExtentSparkReporter("C:/Users/Sherif/IdeaProjects/Konecta_Task6/src/test/java/utils/Report.html");
        extent.attachReporter(sparkReporter);
    }


    @BeforeClass
    public void SetUp(){
        driver = new ChromeDriver();
        goHome();
    }
    public void goHome(){
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void TearDown(){
        driver.quit();
    }

    @AfterSuite
    public void TearDownReport(){
        extent.flush();
    }
}
