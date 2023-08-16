package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatronPageObject {
    private WebDriver driver;
    private PatronPageObject patronPageObject;

    //Constructor
    public PatronPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public PatronPageObject() {
    }

    // Método para buscar por Selector de css
    public void clickButton() {
        driver.findElement(By.cssSelector("")).click();
    }
    // Método para buscar por name
    public void clickButton2(){
        driver.findElement(By.name("")).click();
    }
    //Método para buscar por className
    public void clickButton3(){
        driver.findElement(By.className("")).click();
    }

}
