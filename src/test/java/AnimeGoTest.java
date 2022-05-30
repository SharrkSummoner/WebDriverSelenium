import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import javax.xml.xpath.XPath;
import java.util.concurrent.TimeUnit;

public class AnimeGoTest {

    WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.edge.driver", "drivers\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://animego.org/");
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void buttonAnimeTest() {
        driver.findElement(By.xpath(".//*[@title='Список аниме']")).click();

        var actualResult = driver.getCurrentUrl();
        var expectedResult = "https://animego.org/anime";

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void buttonOngoingsTest() {
        driver.findElement(By.xpath(".//*[@title='Онгоинги аниме']")).click();

        var actualResult = driver.getCurrentUrl();
        var expectedResult = "https://animego.org/anime/status/ongoing";

        Assert.assertEquals(expectedResult, actualResult);
    }

//    @Test
//    public void textThisSeasonAnimeTest() {
//        driver.findElement(By.xpath(".//*[@name='Аниме весеннего сезона'")).click();
//
//        var actualResult = driver.getCurrentUrl();
//        var expectedResult = "https://animego.org/anime/season/2022/spring";
//
//        Assert.assertEquals(expectedResult, actualResult);
//    }
}
