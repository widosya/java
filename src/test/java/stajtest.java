import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class stajtest {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        //запуск веб-драйвера
        System.setProperty("webdriver.chrome.driver", args[0]);
        driver = new ChromeDriver();

        //подготовка страницы к работе
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //переход на тестируемый сайт
        driver.get("https://demoqa.com/login");

        //выполнение авторизации
        WebElement Login = driver.findElement(By.id("userName"));
        Login.sendKeys(args[1]);
        WebElement Password = driver.findElement(By.id("password"));
        Password.sendKeys(args[2]);
        Thread.sleep(1500);
        WebElement logButton = driver.findElement(By.id("login"));
        logButton.click();

        Thread.sleep(2500);

        //переход на страницу книжного каталога
        WebElement bookStore = driver.findElement(By.id("gotoStore"));
        bookStore.click();

        Thread.sleep(2500);

        //выполнение поиска
        WebElement searchBook = driver.findElement(By.id("searchBox"));
        searchBook.sendKeys("git");
        Thread.sleep(2500);
        searchBook.sendKeys(Keys.CONTROL + "a");
        searchBook.sendKeys(Keys.DELETE);
        Thread.sleep(2500);

        //настройка количества книг
        WebElement rowButton = driver.findElement(By.cssSelector(".-pageSizeOptions"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", rowButton);
        Thread.sleep(1500);
        rowButton.click();
        Thread.sleep(2500);
        Select sel = new Select(driver.findElement(By.cssSelector("[aria-label='rows per page']")));
        sel.selectByVisibleText("5 rows");

        Thread.sleep(2500);

        //проверка кнопок перехода по страницам
        WebElement nextButton = driver.findElement(By.className("-next"));
        nextButton.click();
        Thread.sleep(2500);
        WebElement previousButton = driver.findElement(By.className("-previous"));
        previousButton.click();


        Thread.sleep(1500);


        driver.quit();

    }

}
