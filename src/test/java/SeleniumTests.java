import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumTests {
    @Test
    public void testEdgeDriver() {
        // Путь к драйверу
        System.setProperty("webdriver.edge.driver", "drivers\\msedgedriver.exe");

        // Инициализируем edgedriver
        WebDriver driver = new EdgeDriver();
        // Задаем размер окна
        driver.manage().window().maximize();

        // Не будем кушать печеньки :(
        driver.manage().deleteAllCookies();

        // Время на подумать, иначе тест завершиться раньше, чем страница загрузится
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Будем использовать поиск google
        driver.get("https://www.google.com/");

        // Находим элемент ввода и ищем vk
        driver.findElement(By.name("q")).sendKeys("vk");

        // Выполняем сам моиск
        WebElement searchIcon = driver.findElement(By.name("btnK"));
        searchIcon.click();

        // Ищем элемент, записываем в переменную и выполянем его
        WebElement vk = driver.findElement(By.className("l"));
        vk.click();

        // Получаем текст от нашего элемента
        var actualResult =  vk.getText();

        // Ожидаемый результат
        var expectedResult = "Вход";

        // Сравниваем результаты
        Assert.assertEquals(expectedResult, actualResult);

        // Закрываем браузер
        driver.quit();
    }
}
