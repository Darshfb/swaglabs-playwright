package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class P03_CartPage
{
    private final Page page;
    public P03_CartPage(Page page)
    {
        this.page = page;
    }
    protected Locator checkoutStepOne()
    {
        return page.locator("(//a)[text()='CHECKOUT']");
    }

    public void navigateToCheckoutStepOne(){
        checkoutStepOne().click();
    }
}
