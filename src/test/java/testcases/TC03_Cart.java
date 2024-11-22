package testcases;

import org.testng.annotations.Test;
import pages.P03_CartPage;

public class TC03_Cart extends TestBase
{

    @Test(priority = 1, description = "Navigate to checkout step one")
    public void navigateToCheckoutStepOne()
    {
        new P03_CartPage(page).navigateToCheckoutStepOne();
    }
}
