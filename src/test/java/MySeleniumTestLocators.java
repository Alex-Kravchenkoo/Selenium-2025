import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class MySeleniumTestLocators {
    @Test
    public void firstSeleniumTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));

        driver.get("https://litecart.stqa.ru/en/");

        driver.manage().window().maximize();
        //Тест 1

        WebElement home = driver.findElement(By.cssSelector("i.fa.fa-home"));

        home.click();

        String pageTitle = driver.getTitle();

        Assert.assertEquals(pageTitle, "Online Store | My Store");


//        Тест 2
//
//        WebElement rubberDucks = driver.findElement(
//                By.xpath("//nav[@id='site-menu']//a[@href='https://litecart.stqa.ru/en/rubber-ducks-c-1/']"));
//
//        rubberDucks.click();
//
//        String pageTitleRD = driver.getTitle();
//
//        Assert.assertEquals(pageTitleRD, "Rubber Ducks | My Store");

        //Тест 3
//
//        WebElement rubberDucks = driver.findElement(
//                By.xpath("//nav[@id='site-menu']//a[@href='https://litecart.stqa.ru/en/rubber-ducks-c-1/']"));
//
//        Actions actions = new Actions(driver);
//
//        actions.moveToElement(rubberDucks).perform();
//
//        WebElement subcategory = driver.findElement(By.xpath("//*[@id='site-menu']/ul/li[2]/ul/li/a"));
//
//        subcategory.click();
//
//        WebElement titleSubcategory = driver.findElement(By.xpath("//*[@id='box-category']/h1"));
//
//        Assert.assertEquals(titleSubcategory.getText(), "Subcategory");


    }
}
