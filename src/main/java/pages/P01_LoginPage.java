package pages;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class P01_LoginPage
{
    private final Page page;
    public P01_LoginPage(Page page)
    {
        this.page = page;
    }
    private Locator userName(){
        return page.locator("(//input)[@data-test='username']");
    }
    private Locator password(){
        return page.locator("(//input)[@data-test='password']");
    }
    private Locator loginButton(){
        return page.locator("#login-button");
    }


    public P01_LoginPage enterUserName(String username)
    {
        userName().waitFor(new Locator.WaitForOptions().setTimeout(2000));
        userName().fill(username);
        return this;
    }

    public P01_LoginPage enterPassword(String password)
    {
        password().fill(password);
        return this;
    }

    public void clickLoginButton()
    {
        loginButton().click();
    }
}
