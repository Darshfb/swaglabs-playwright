package testcases;
import org.testng.annotations.Test;
import pages.P04_CheckoutStepOne;

public class TC04_CheckoutFirstStep extends TestBase
{
    @Test(priority = 1, description = "Enter to checkout step two")
    public void enterToCheckoutPage()
    {
        new P04_CheckoutStepOne(page)
                .enterFirstName(faker.name().name())
                .enterLastName(faker.name().lastName())
                .enterPostalCode(faker.address().zipCode())
                .submit();
    }
}
