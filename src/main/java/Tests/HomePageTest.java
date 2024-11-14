package Tests;

import Pages.HomePage;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase
{
    HomePage HomepageObject;
    @Test
    public void SearchTest()
    {
        HomepageObject = new HomePage(driver);
        HomepageObject.search("Monitors (2)");
    }
}
