package selenide.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class OpenCart {

    @Test
    public void test() throws InterruptedException {
        open("https://opencart.abstracta.us/");
        WebDriverRunner.getWebDriver().manage().window().maximize();

        $x("//span[normalize-space()='My Account']")
                .click();
        $x("//a[normalize-space()='Login']").click();

        $("#input-email")
                .shouldBe(Condition.visible)
                .setValue("testngkurs@gmail.com");

        $("#input-password")
                .shouldBe(Condition.visible)
                .setValue("testngkurs")
                .pressEnter();

          $x("//a[normalize-space()='Logout']").should(Condition.exist);

        $("input[placeholder='Search']")
                .shouldBe(Condition.visible)
                .setValue("mac")
                .pressEnter();

        $("div.product-layout",1)
                .shouldBe(Condition.visible)
                .find(By.xpath(".//button[.//*[text()='Add to Cart']]"))
                .click();

        Thread.sleep(3000);
    }
}
