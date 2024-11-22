package testcases;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

@Listeners(listeners.Listener.class)
public class TestBase {
//    static WebDriver driver;
    protected Faker faker = new Faker();
    // extend report
    protected static ExtentSparkReporter htmlReporter;
    protected static ExtentReports extent;
    protected static ExtentTest test;
    private static String PROJECT_NAME = null;
    private static String PROJECT_URL = null;

    // define Suite Elements
    static Properties prop;
    static FileInputStream readProperty;

    // playwright
    protected Browser browser;
    protected static Page page;
    protected Playwright playwright;
    protected BrowserType browserType;

    @BeforeSuite
    public void beforeSuite() throws Exception {
        // TODO: initialize the HtmlReporter
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/testReport.html");

        //initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        setProjectDetails();

        // initialize test
        test = extent.createTest(PROJECT_NAME + " Test Automation Project");

        //configuration items to change the look and fee add content, manage tests etc
        htmlReporter.config().setDocumentTitle(PROJECT_NAME + " Test Automation Report");
        htmlReporter.config().setReportName(PROJECT_NAME + " Test Report");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }

    private void setProjectDetails() throws IOException {
        // TODO: Step1: define object of properties file
        readProperty = new FileInputStream(
                System.getProperty("user.dir") + "/src/test/resources/properties/environment.properties");
        prop = new Properties();
        prop.load(readProperty);

        // define project name from properties file
        PROJECT_NAME = prop.getProperty("projectName");
        PROJECT_URL = prop.getProperty("url");
    }


    @Parameters("browserName")
    @BeforeTest
    public void setupDriver(String browserName) {
        // Initialize Playwright
        playwright = Playwright.create();
        browserType = null;
        System.out.println("Browser Name: " + browserName);
        // Setup Browser based on input parameters
        if (browserName.equalsIgnoreCase("chromium")) {
            browserType = playwright.chromium();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            browserType = playwright.firefox();
        } else if (browserName.equalsIgnoreCase("webkit")) {
            browserType = playwright.webkit();
        }

        // Launch browser
        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));

        // Create a context with video recording enabled
        BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                .setRecordVideoDir(Paths.get("videos/"))  // Directory to save video recordings
                .setRecordVideoSize(1280, 720)) ;   // Resolution for video recording

        // Create a new page in the context
        page = context.newPage();

        // Maximize window (Playwright automatically launches maximized)
        page.navigate(PROJECT_URL, new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));
    }

    @AfterTest
    public void tearDown() {
        page.close();
    }

    @AfterSuite
    public void afterSuite() {
        extent.flush();
    }

    @AfterMethod
    public void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, result.getName() + " failed with the following error: " + result.getThrowable());
            Reporter.log("Failed to perform " + result.getName(), 10, true);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, result.getName());
            Reporter.log("Successfully perform " + result.getName(), 10, true);
        } else {
            test.log(Status.SKIP, result.getName());
            Reporter.log("Skip " + result.getName(), 10, true);
        }
    }


}
