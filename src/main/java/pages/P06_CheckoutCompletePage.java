package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class P06_CheckoutCompletePage
{
    private final Page page;
    public P06_CheckoutCompletePage(Page page)
    {
        this.page = page;
    }

    private Locator successMessage()
    {
        return page.locator("(//h2)[@class='complete-header']");
    }

    public Boolean checkSuccessOrder()
    {
        return successMessage().textContent().equals("THANK YOU FOR YOUR ORDER");
    }
}
