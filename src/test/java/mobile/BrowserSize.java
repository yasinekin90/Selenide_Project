package mobile;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.Driver;

public class BrowserSize {

    WebDriver driver;

    @Test
    public void test1() throws InterruptedException {
        driver= Driver.getWebDriver();
    driver.manage().window().setPosition(new Point(500,100));
    driver.manage().window().setSize(new Dimension(500,600));
    driver.get("https://google.com");
    Thread.sleep(3000);
    driver.quit();

    }
}
