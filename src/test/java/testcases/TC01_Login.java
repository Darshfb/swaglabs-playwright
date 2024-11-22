package testcases;
import org.testng.annotations.Test;
import pages.P01_LoginPage;

public class TC01_Login extends TestBase
{
    String userName = "standard_user";
    String password = "secret_sauce";
    @Test(priority = 1, description = "Login with valid credentials")
    public void loginWithValidCredentials()
    {
        System.out.println("page " + page.url());

        new P01_LoginPage(page)
                .enterUserName(userName)
                .enterPassword(password)
                .clickLoginButton();

    }
}
