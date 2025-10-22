import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class MySeleniumTest {
    @Test
    public void firstSeleniumTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));

        driver.get("https://litecart.stqa.ru/en/");

        driver.manage().window().maximize();

        WebElement cartLink = driver.findElement(By.id("cart"));

        cartLink.click();

        WebElement backLink = driver.findElement(By.cssSelector("a[href='https://litecart.stqa.ru/en/']"));

        backLink.click();

        WebElement searchBox = driver.findElement(By.name("query"));

        searchBox.sendKeys("Green Duck");

        searchBox.sendKeys(Keys.ENTER);

        Actions actions = new Actions(driver);

//        List<WebElement> rubberDuckImages = driver.findElements(By.className("image-wrapper"));
//
//        Assert.assertEquals(rubberDuckImages.size(), 6)


        //cartLink.click();

        //WebElement backLink = driver.findElement(By.cssSelector("a.link"));

        //backLink.click();

    }
}
