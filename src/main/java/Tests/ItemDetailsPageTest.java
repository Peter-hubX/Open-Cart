package Tests;

import Pages.ItemDetailsPage;
import org.testng.annotations.Test;

import java.awt.*;

public class ItemDetailsPageTest extends TestBase {

    ItemDetailsPage ItemDetailsPageObject;

    @Test
    public void test() throws AWTException, InterruptedException {
        // Remove driver argument from constructor
        ItemDetailsPageObject = new ItemDetailsPage(driver);  // No need to pass driver here
        ItemDetailsPageObject.FillData();
        ItemDetailsPageObject.UploadFile();
        ItemDetailsPageObject.alert();
        //ItemDetailsPageObject.FindDate();  // Uncomment if needed
        ItemDetailsPageObject.Submit();
        ItemDetailsPageObject.ViewCart();
        Thread.sleep(2000);
    }
}
