package testcases;

import org.testng.annotations.Test;
import pages.P02_HomePage;

public class TC02_Home extends TestBase {
    static double totalPrices;

    @Test(priority = 1, description = "Add item to cart")
    public void addItemToCart()
    {
        totalPrices = new P02_HomePage(page)
                .addItemToCart()
                .navigateToCartPage()
                .getTotalPrice();
        System.out.println("The sum is " + totalPrices);
    }
}
