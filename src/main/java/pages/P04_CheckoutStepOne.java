package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class P04_CheckoutStepOne
{
    private final Page page;
    public P04_CheckoutStepOne(Page page)
    {
        this.page = page;
    }

    private Locator firstNameTextField()
    {
        return page.locator("#first-name");
    }
    private Locator lastNameTextField()
    {
        return page.locator("#last-name");
    }
    private Locator postalCodeTextField()
    {
        return page.locator("#postal-code");
    }
    private Locator submitButton()
    {
        return page.locator("(//input)[@type='submit']");
    }

    public P04_CheckoutStepOne enterFirstName(String userName)
    {
        firstNameTextField().fill(userName);
        return this;
    }

    public P04_CheckoutStepOne enterLastName(String lastName)
    {
        lastNameTextField().fill(lastName);
        return this;
    }

    public P04_CheckoutStepOne enterPostalCode(String postalCode)
    {
        postalCodeTextField().fill(postalCode);
        return this;
    }

    public void submit(){
        submitButton().click();
    }

}
