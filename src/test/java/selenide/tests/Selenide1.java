package selenide.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.awt.event.KeyEvent;

import static com.codeborne.selenide.Selenide.*;

public class Selenide1 {

    /**
     * open();
     * $()   -> driver.findElement  içerisine cssselector yazılır
     * $$()   ->driver.findElements
     * action
     * $x()  -> içerisine direk olarak xpath yazılabilir
     * $(By.xpath("")) bu sekildede xpath yazılır
     */
    @Test
    public void test1(){

       // Configuration.browser="firefox"; driver değiştirmek icin
        open("https://opencart.abstracta.us/");
        WebDriverRunner.getWebDriver().manage().window().maximize();
        $("input[placeholder='Search']")
                .shouldBe(Condition.visible)
                .setValue("mac")
                .pressEnter();

        $$("div.product-layout")// 4 elementi locate eder
                .shouldHave(CollectionCondition.sizeGreaterThan(1))
                .filter(Condition.matchText(".*MacBook*."))
                .forEach(n-> System.out.println(n.getText()));


        $$("ul.nav>li").forEach(e->{
            e.hover();
            sleep(500);});

       // $x("//a[text()='Brands']").scrollIntoView(true);

        $(getXpathOfHeartButtonWithProductName("MacBook")).click();


//button[@data-original-title='Add to Wish List' and .//ancestor::div[@class='product-thumb' and .//a[text()='MacBook']]]

        sleep(3000);
    }

    public By getXpathOfHeartButtonWithProductName(String productName){

        return By.xpath("//button[@data-original-title='Add to Wish List' and .//ancestor::div[@class='product-thumb' and .//a[text()='"+productName+"']]]");
    }
}
