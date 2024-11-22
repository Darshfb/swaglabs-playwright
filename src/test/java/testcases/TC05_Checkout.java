package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P05_CheckoutPage;

import static testcases.TC02_Home.totalPrices;

public class TC05_Checkout extends TestBase
{
    @Test(priority = 1, description = "Checkout and submit order")
    public void submitOrder()
    {
        Assert.assertTrue(new P05_CheckoutPage(page).checkTotalEqualToSum(totalPrices));
        new P05_CheckoutPage(page).submitOrder();
    }
}
