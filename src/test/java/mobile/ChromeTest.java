package mobile;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.Driver;

public class ChromeTest {

    WebDriver driver;

    @Test
    public void test1() throws InterruptedException {
    driver= Driver.getWebDriver();
    driver.get("https://google.com");
    Thread.sleep(2000);
    driver.quit();

    }
}
