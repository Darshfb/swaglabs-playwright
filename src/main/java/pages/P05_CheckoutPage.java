package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class P05_CheckoutPage
{
    private final Page page;
    public P05_CheckoutPage(Page page)
    {
        this.page = page;
    }

    private Locator subtotal(){
        return page.locator("(//div)[@class='summary_subtotal_label']");
    }
    private Locator finishButton(){
        return page.locator("(//a)[text()='FINISH']");
    }

    public void submitOrder()
    {
        finishButton().click();
    }

    public Boolean checkTotalEqualToSum(double expectedPrice) {
        String subtotal = subtotal().textContent();
        double specificItemPrice = Double.parseDouble(subtotal.substring(13));
        return (specificItemPrice == expectedPrice);
    }
}
