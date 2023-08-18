package tests;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PatronPageObject;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PruebasWeb {


    @Test
    public void testWeb1() {
        WebDriver driver = new ChromeDriver();
        //Abro web
        driver.get("https://lidl.es");
        //Acepto cookies
        driver.findElement(By.cssSelector("button[class='cookie-alert-extended-button']")).click();


        //Click en botón Parkside
        driver.findElement(By.className("ABrandOverview__Image")).click();

        //Lee mensaje de la class y lo guardo en un string, después comparo con assertequals el esperado y el valor del string
        WebElement message = driver.findElement(By.className("result_count"));
        String value = message.getText();
        assertEquals("872 productos", value);
    }

    @Test
    public void TestWeb2() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://lidl.es");
        driver.findElement(By.cssSelector("button[class='cookie-alert-extended-button']")).click();

        // Busco elemento buscador e introduzco "salchichas", hago click
        WebElement buscador = driver.findElement(By.name("query"));
        WebElement buscarboton = driver.findElement(By.className("primary"));
        buscador.sendKeys("salchichas");
        buscarboton.click();

        // Comparo resultado que aparece en web con esperado
        WebElement message = driver.findElement(By.className("result_count"));
        String value = message.getText();
        assertEquals("2 productos", value);
    }

    @Test
    public void TestWeb3() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://lidl.es");
        driver.findElement(By.cssSelector("button[class='cookie-alert-extended-button']")).click();

        // Busco elemento buscador e introduzco "salchichas", hago click
        WebElement buscador = driver.findElement(By.name("query"));
        WebElement buscarboton = driver.findElement(By.className("primary"));
        buscador.sendKeys("piscina perros");
        buscarboton.click();

        // Busco carrito y hago click
        driver.findElement(By.className("frontpage-product-teaser__addtocart")).click();

        //Introduzco un wait para asegurar que se carga la web
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://www.lidl.es/es/basket/validate");

        // Navego hacia atrás
        driver.navigate().back();
        driver.get("https://www.lidl.es/es/basket/contents");

        // Busco texto en web en el que aparezca "Tu cesta" y compruebo con esperado
        WebElement message = driver.findElement(By.className("nohero-heading"));
        String value = message.getText();
        assertEquals("Tu cesta", value);
    }
}

