package Tests;

import Pages.CheckOutPage;
import org.testng.annotations.Test;

public class CheckOutPageTest extends TestBase
{
    CheckOutPage CheckOutPageObject;
    @Test(priority = 1)
    public void validateCheckoutForm() throws InterruptedException {
        CheckOutPageObject = new CheckOutPage(driver);
        CheckOutPageObject.ConfirmButtonClick();
        //Thread.sleep(3000);
    }
    @Test(priority = 2)
    public void PanelTest() throws InterruptedException {
        CheckOutPageObject = new CheckOutPage(driver);
        CheckOutPageObject.setPanel();
        //Thread.sleep(3000);
    }

    @Test(priority = 3)
    public void proceedToCheckoutTest() throws InterruptedException
    {
        //Before Trying change the Email and Zone numbers
        CheckOutPageObject = new CheckOutPage(driver);
        CheckOutPageObject.fillCheckoutForm
                (
                "John",
                 "Doe",
                 "johnYVZADF.doe@example.com",
                 "1234567890",
                 "1234",
                 "1234",
                 "123 Main St",
                 "ABCD",
                 "10001",
                        "3527"
                );
    }
}
