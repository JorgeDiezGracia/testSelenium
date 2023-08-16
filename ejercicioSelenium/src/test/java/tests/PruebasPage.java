package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PatronPageObject;

public class PruebasPage {
    public static void main(String[] args) {

        PatronPageObject pageObject = new PatronPageObject();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jorge Díez\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://lidl.es");

        PatronPageObject patronPageObject = new PatronPageObject(driver);

        patronPageObject.clickButton();
        patronPageObject.clickButton2();
        patronPageObject.clickButton3();


    }
}
