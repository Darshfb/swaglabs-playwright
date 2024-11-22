package pages;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.util.ArrayList;
import java.util.List;

import static utility.Utility.generateRandomNumber;

public class P02_HomePage {
    private final Page page;

    public P02_HomePage(Page page) {
        this.page = page;

    }

    private Locator addToCart(int itemIndex) {
        return page.locator("//div[@class='inventory_list']//div[" + itemIndex + "]//div[3]//button[1]");
    }

    private Locator cartPage() {
        return page.locator("#shopping_cart_container");
    }

    private Locator itemPrice(int index)
    {
        return page.locator("((//div)[@class='inventory_item_price'])["+index+"]");
    }
    List<Double> listPrices = new ArrayList<>();


    public P02_HomePage addItemToCart() {
        int totalItems = generateRandomNumber();
        addToCart(5).waitFor(new Locator.WaitForOptions().setTimeout(5000));

        System.out.println(totalItems + " Total items");
        for (int i = 1 ; i <= totalItems; i++)
        {
            int index = generateRandomNumber();
            System.out.println("The index " + index + "and i is " + i);
            if(addToCart(index).textContent().equals("ADD TO CART"))
            {
                addToCart(index).click();
                String price = itemPrice(index).textContent().substring(1);
                listPrices.add(Double.parseDouble(price));
            }else{
                System.out.println("The item " + index + " is Selected before");
            }
        }

        return this;
    }

    public P02_HomePage navigateToCartPage() {
        cartPage().click();
        return this;
    }

    public double getTotalPrice() {
        System.out.println("The total list of prices is : " + listPrices);
        double sum =  listPrices.stream().mapToDouble(Double::doubleValue).sum();
        return Math.round(sum * 100.0) / 100.0;
    }

}
