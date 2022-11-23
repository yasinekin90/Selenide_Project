package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getWebDriver(){
        if(driver==null){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }

        return driver;
    }

//            WebDriverManager.chromedriver().setup();          mobil test için
//            ChromeOptions option=new ChromeOptions();
//            option.setExperimentalOption("androidPackage","com.android.chrome");
//            driver=new ChromeDriver();

}
