package Tests;

import Pages.CheckOutPage;
import org.openqa.selenium.io.Zip;
import org.testng.annotations.Test;

public class CheckOutPageTest extends TestBase
{
    CheckOutPage CheckOutPageObject;
    @Test
    public void proceedToCheckoutTest() throws InterruptedException {
        CheckOutPageObject = new CheckOutPage(driver);
        CheckOutPageObject.fillCheckoutForm(
                "John",
                 "Doe",
                 "john.doe@example.com",
                 "1234567890",
                 "1234",
                 "1234",
                 "123 Main St",
                 "ABCD",
                 "10001",
                 "Greater Manchester"
                );
    }
}
