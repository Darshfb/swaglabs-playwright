package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P06_CheckoutCompletePage;

public class TC06_CheckoutComplete extends TestBase
{
    @Test(priority = 1, description = "Order is success and checkout completed")
    public void successOrder(){
        Assert.assertTrue(new P06_CheckoutCompletePage(page).checkSuccessOrder());
    }
}
