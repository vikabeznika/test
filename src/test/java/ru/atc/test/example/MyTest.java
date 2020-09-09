package ru.atc.test.example;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class MyTest {
    static protected WebDriver driver;


        /**
         * осуществление первоначальной настройки
         */
        @BeforeClass
        public static void setup() {
            //определение пути до драйвера и его настройка
            System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
            //создание экземпляра драйвера
            WebDriver driver = new ChromeDriver();
            //окно разворачивается на полный экран
            driver.manage().window().maximize();
            //задержка на выполнение теста = 10 сек.
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //получение ссылки на страницу входа из файла настроек
            driver.get(ConfProperties.getProperty("loginpage"));
            //driver.get("C:\\Projects\\my-test\\src\\test\\resources\\helloWorldPage.html");
        }



    @Test
    public void loginTest() {
    String text1 = "Hello, World!";
    String text = "Войдите, чтобы продолжить";
    System.out.println("hello");
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
        Assert.assertTrue(text, list.size() > 0);
    }

}
